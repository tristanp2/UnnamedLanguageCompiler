package Visitor;
import AST.*;
import Types.*;
import Environment.*;

public class TypeCheckVisitor implements TypeVisitor{
    private class FunctionInfo{
        FormalParameterList fpl;
        Type t;
        public FunctionInfo(FormalParameterList fpl, Type t){
            this.fpl = fpl;
            this.t = t;
        }
    }

    ListEnvironment variableEnvironment;
    ListEnvironment functionEnvironment;
    String current_function_name;
    boolean main_encountered;

    public TypeCheckVisitor(){
        variableEnvironment = new ListEnvironment();
        functionEnvironment = new ListEnvironment();
        main_encountered = false;
    }

	public Type visit (AddExpression e) throws SemanticException {
        if(e.expr2 == null) return e.expr1.accept(this);
        Type t1 = e.expr1.accept(this);
        Type t2 = e.expr2.accept(this);
        
        if(t1.equals(new IntegerType()) || t1.equals(new FloatType()) ||
            t1.equals(new CharType()) || t1.equals(new StringType())){
            if(t1.equals(t2)){
                return t1;
            }
            else{
                throw new SemanticException("Mismatched types in addition --> " + t1 + ", " + t2,
                                                e.line_number, e.offset);
            }
        }
        else{
            throw new SemanticException("Invalid type in addition --> " + t1, e.line_number, e.offset);
        }
    }
	public Type visit (ArrayType a) throws SemanticException {
        return a;
    }
	public Type visit (ArrayAssignment s) throws SemanticException {
        ArrayType at = (ArrayType)variableEnvironment.lookup(s.id.name);
        Type exprType = s.expr.accept(this);
        Type indexType = s.index.accept(this);
        if(!at.elementType().equals(exprType) || !indexType.equals(new IntegerType())){
            throw new SemanticException("Mismatched types in array assignment --> " + at.elementType() 
                                            + ", " + exprType, s.line_number, s.offset);
        }
        else return at;
    }
	public Type visit (ArrayReference a) throws SemanticException {
        ArrayType at;
        Type temp = null;
        try{
            temp = (Type)variableEnvironment.lookup(a.id.name);
            at = (ArrayType)temp;
        }
        catch(ClassCastException e){
            throw new SemanticException(a.id.name + " is of type " + temp + " but is referenced as array",
                                        a.line_number, a.offset);
        }

        Type et = a.index.accept(this);
        if(!et.equals(new IntegerType())){
            throw new SemanticException("Index expression is of invalid type\n\tExpected: int" 
                                        + "\tGot: " + et, a.index.line_number, a.index.offset);
        }
        return at.elementType();
    }
	public Type visit (Block b) throws SemanticException {
        int size = b.size();
        for(int i=0; i<size; i++){
            b.elementAt(i).accept(this);
        }
        return null;
    }
	public Type visit (BooleanLiteral b) throws SemanticException {
        return new BooleanType();
    }
	public Type visit (CharacterLiteral c) throws SemanticException {
        return new CharType();
    }
    public Type visit (EmptyStatement es) throws SemanticException {
        return null;
    }
	public Type visit (EqualityExpression e) throws SemanticException {
        if(e.expr2 == null) return e.expr1.accept(this);
        Type t1 = e.expr1.accept(this);
        Type t2 = e.expr2.accept(this);
        
        if(!t1.equals(new VoidType())){
            if(t1.equals(t2)){
                return new BooleanType();
            }
            else{
                throw new SemanticException("Mismatched types in equality --> " + t1 + ", " + t2,
                                                e.line_number, e.offset);
            }
        }
        else{
            throw new SemanticException("Invalid type in equality --> " + t1, e.line_number, e.offset);
        }
    }
    //only occurs in function calls
	public Type visit (ExpressionList el) throws SemanticException {
        return null;
    }
	public Type visit (ExpressionStatement e) throws SemanticException {
        return e.expr.accept(this);
    }
	public Type visit (FloatLiteral f) throws SemanticException {
        return new FloatType();
    }	
	public Type visit (FormalParameter p) throws SemanticException {
        Type t = p.type.accept(this);
        if(variableEnvironment.inCurrentScope(p.id.name)){
            throw new SemanticException("Name conflict in function parameters --> " + p.id.name
                                            , p.line_number, p.offset);
        }
        else if(t.equals(new VoidType())){
            throw new SemanticException("Parameter cannot be of type void", p.line_number, p.offset);
        }
        else{
            variableEnvironment.add(p.id.name, p.type.accept(this));
        }

        return t;
    }
	public Type visit (FormalParameterList fpl) throws SemanticException {
        int size = fpl.size();
        for(int i=0; i<size; i++){
            fpl.elementAt(i).accept(this);
        }
        return null;
    }
	public Type visit (Function f) throws SemanticException {
        variableEnvironment.beginScope();

        current_function_name = f.funcDec.id.name;
        if(f.funcDec.paramList != null){
            f.funcDec.paramList.accept(this);
        }
        f.funcBody.accept(this);
        variableEnvironment.endScope();
        return null;
    }
	public Type visit (FunctionBody f) throws SemanticException {
        int decSize = f.declarationSize();
        int statSize = f.statementSize();
        for(int i=0; i < decSize; i++){
            f.declarationAt(i).accept(this);
        }

        for(int i=0; i < statSize; i++){
            f.statementAt(i).accept(this);
        }

        return null;
    }
	public Type visit (FunctionCall f) throws SemanticException {
        FunctionInfo fi = (FunctionInfo)functionEnvironment.lookup(f.id.name);
        if(f.exprList == null){
            if(fi.fpl != null){
                throw new SemanticException("Wrong number of parameters when calling " + f.id.name +
                                            ".\n\tExpected: " + fi.fpl.size() + "\tGot: 0", f.line_number, f.offset);
            }
        }
        else if(fi.fpl == null){
            throw new SemanticException("Wrong number of parameters when calling " + f.id.name +
                                        ".\n\tExpected: 0\tGot: " + f.exprList.size(), f.line_number, f.offset);
        }
        else{
            int size = f.exprList.size();
            if(fi.fpl.size() != size){
                throw new SemanticException("Wrong number of parameters when calling " + f.id.name +
                                            ".\n\tExpected: " + fi.fpl.size() + "\tGot: " + 
                                                size, f.line_number, f.offset);
            }

            for(int i=0; i<size; i++){
                Expression e = f.exprList.elementAt(i);
                FormalParameter fp = fi.fpl.elementAt(i);
                Type t1 = e.accept(this);
                Type t2 = fp.type.accept(this);

                if(!t1.equals(t2)){
                    throw new SemanticException("Parameter " + i + " mismatched in call to function " + f.id.name +
                                                ".\n\tExpected: " + t2 + "\tGot: " + t1, e.line_number, e.offset);
                }
            }
        }
        return fi.t;
    }
	public Type visit (FunctionDeclaration f) throws SemanticException {
        if(functionEnvironment.inCurrentScope(f.id.name)){
            throw new SemanticException("Duplicate function declaration --> " + f.id.name + " already declared",
                                        f.line_number, f.offset);
        }
        if(f.paramList != null){
            if(f.id.name.equals("main")){
                throw new SemanticException("main function cannot take any parameters", f.line_number, f.offset);
            }
        }

        Type fType = f.type.accept(this);
        if(f.id.name.equals("main")){
            if(fType.equals(new VoidType())){
                main_encountered = true;
            }
            else{
                throw new SemanticException("main function must be of type void", f.line_number, f.offset);
            }
        }
        functionEnvironment.add(f.id.name, new FunctionInfo(f.paramList, fType));
        return null;
    }
	public Type visit (Identifier i) throws SemanticException {
        if(!variableEnvironment.inCurrentScope(i.name)){
            throw new SemanticException("Symbol not found --> " + i.name, i.line_number, i.offset);
        }
        return (Type)variableEnvironment.lookup(i.name);
    }
	public Type visit (IdentifierValue v) throws SemanticException {
        return v.id.accept(this);
    }
	public Type visit (IfStatement i) throws SemanticException {
        Type condExpr = i.condition.accept(this);
        if(!condExpr.equals(new BooleanType())){
            throw new SemanticException("wrong condition type --> " + condExpr, i.line_number, i.offset);
        }
        i.ifBlock.accept(this);
        if(i.elseBlock != null){
            i.elseBlock.accept(this);
        }
        return null;
    }
	public Type visit (IntegerLiteral i) throws SemanticException {
        return new IntegerType();
    }
	public Type visit (LessThanExpression e) throws SemanticException {
        if(e.expr2 == null) return e.expr1.accept(this);
        Type t1 = e.expr1.accept(this);
        Type t2 = e.expr2.accept(this);
        
        if(!t1.equals(new VoidType())){
            if(t1.equals(t2)){
                return new BooleanType();
            }
            else{
                throw new SemanticException("Mismatched types in less than --> " + t1 + ", " + t2, 
                                                e.line_number, e.offset);
            }
        }
        else{
            throw new SemanticException("Invalid type in less than --> " + t1,
                                            e.line_number, e.offset);
        }
    }
	public Type visit (MultExpression e) throws SemanticException {
        if(e.expr2 == null) return e.expr1.accept(this);
        Type t1 = e.expr1.accept(this);
        Type t2 = e.expr2.accept(this);
        
        if(t1.equals(new IntegerType()) || t1.equals(new FloatType())){
            if(t1.equals(t2)){
                return t1;
            }
            else{
                throw new SemanticException("Mismatched types in multiplication --> " + t1 + ", " + t2, 
                                                e.line_number, e.offset);
            }
        }
        else{
            throw new SemanticException("Invalid type in multiplication --> " + t1,
                                            e.line_number, e.offset);
        }
    }
	public Type visit (ParenExpression p) throws SemanticException {
        return p.expr.accept(this);
    }
	public Type visit (PrintLnStatement s) throws SemanticException {
        Type t = s.expr.accept(this);
        if(t.equals(new VoidType())){
            throw new SemanticException("Invalid println expression. Cannot print void type", s.line_number,
                                            s.offset);
        }
        return null;
    }
	public Type visit (PrintStatement s) throws SemanticException {
        Type t = s.expr.accept(this);
        if(t.equals(new VoidType())){
            throw new SemanticException("Invalid print expression. Cannot print void type", s.line_number,
                                            s.offset);
        }
        return null;
    }	
	public Type visit (Program p) throws SemanticException {
        int size = p.size();
        //pass to pickup the function decs first
        for(int i=0; i<size; i++){
            Function f = p.elementAt(i);
            f.funcDec.accept(this);
        }
        for(int i=0; i < size; i++){
            p.elementAt(i).accept(this);
        }
        if(!main_encountered){
            throw new SemanticException("Program must have main function", p.line_number, p.offset);
        }
        return null;
    }
	public Type visit (ReturnStatement s) throws SemanticException {
        FunctionInfo fi = (FunctionInfo)functionEnvironment.lookup(current_function_name);
        Type et = s.expr.accept(this);
        if(!et.equals(fi.t)){
            throw new SemanticException("Returned type does not match function type\n\tExpected: " + fi.t
                                        + "\tGot: " + et, s.line_number, s.offset);
        }
        return null;
    }
	public Type visit (StringLiteral s) throws SemanticException {
        return new StringType();
    }
	public Type visit (SubtractExpression e) throws SemanticException {
        if(e.expr2 == null) return e.expr1.accept(this);
        Type t1 = e.expr1.accept(this);
        Type t2 = e.expr2.accept(this);
        
        if(t1.equals(new IntegerType()) || t1.equals(new FloatType()) ||
            t1.equals(new CharType())){
            if(t1.equals(t2)){
                return t1;
            }
            else{
                throw new SemanticException("Mismatched types in mult --> " + t1 + ", " + t2,
                                                e.line_number, e.offset);
            }
        }
        else{
            throw new SemanticException("Invalid type in mult --> " + t1, e.line_number, e.offset);
        }
    }
    public Type visit (UnaryExpression e) throws SemanticException {
        //TODO
        return e.expr.accept(this);
    }
	public Type visit (Type t) throws SemanticException {
        return null;
    }
	public Type visit (TypeNode t) throws SemanticException {
        return t.type;
    }
	public Type visit (VariableAssignment s) throws SemanticException {
        Type varType = (Type)variableEnvironment.lookup(s.id.name);
        Type exprType = s.expr.accept(this);
        if(varType == null){
            throw new SemanticException("Symbol " + s.id.name + " not found", s.line_number, s.offset);
        }
        else if(!varType.equals(exprType)){
            throw new SemanticException("Mismatched types in assignment --> " + varType + ", " + exprType,
                                            s.line_number, s.offset);
        }

        return null;
    }
	public Type visit (VariableDeclaration v) throws SemanticException {
        if(variableEnvironment.inCurrentScope(v.id.name)){
            throw new SemanticException("Duplicate variable declaration --> " + v.id.name + " already declared",
                                            v.line_number, v.offset);
        }
        else if(v.type.accept(this).equals(new VoidType())){
            throw new SemanticException("Variable cannot be of type void", v.line_number, v.offset);
        }
        else{
            variableEnvironment.add(v.id.name, v.type.accept(this));
        }
        return null;
    }
	public Type visit (WhileStatement s) throws SemanticException {
        Type condExpr = s.condition.accept(this);
        if(!condExpr.equals(new BooleanType())){
            throw new SemanticException("wrong condition type --> " + condExpr, s.line_number, s.offset);
        }

        s.body.accept(this);
        return null;
    }
}

