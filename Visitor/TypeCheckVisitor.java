package Visitor;
import AST.*;
import Types.*;
import Environment.*;

public class TypeCheckVisitor implements TypeVisitor{
    ListEnvironment variableEnvironment;
    ListEnvironment functionEnvironment;


    public TypeCheckVisitor(){
        variableEnvironment = new ListEnvironment();
        functionEnvironment = new ListEnvironment();
    }

	public Type visit (AddExpression e) throws SemanticException {
        Type t1 = e.expr1.accept(this);
        Type t2 = e.expr2.accept(this);
        
        if(t1.equals(new IntegerType()) || t1.equals(new FloatType()) ||
            t1.equals(new CharType()) || t1.equals(new StringType())){
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
        return null;
    }
	public Type visit (Block b) throws SemanticException {
        return null;
    }
	public Type visit (BooleanLiteral b) throws SemanticException {
        return null;
    }
	public Type visit (CharacterLiteral c) throws SemanticException {
        return null;
    }
    public Type visit (EmptyStatement es) throws SemanticException {
        return null;
    }
	public Type visit (EqualityExpression e) throws SemanticException {
        return null;
    }
	public Type visit (ExpressionList el) throws SemanticException {
        return null;
    }
	public Type visit (ExpressionStatement e) throws SemanticException {
        return null;
    }
	public Type visit (FloatLiteral f) throws SemanticException {
        return new FloatType();
    }	
	public Type visit (FormalParameter p) throws SemanticException {
        return null;
    }
	public Type visit (Function f) throws SemanticException {
        f.funcDec.accept(this);
        f.funcBody.accept(this);
        return null;
    }
	public Type visit (FunctionBody f) throws SemanticException {
        int decSize = f.declarationSize();
        int statSize = f.statementSize();

        functionEnvironment.beginScope();
        variableEnvironment.beginScope();
        
        for(int i=0; i < decSize; i++){
            f.declarationAt(i).accept(this);
        }

        for(int i=0; i < statSize; i++){
            f.statementAt(i).accept(this);
        }

        functionEnvironment.endScope();
        variableEnvironment.endScope();
        return null;
    }
	public Type visit (FunctionCall f) throws SemanticException {
        return null;
    }
	public Type visit (FunctionDeclaration f) throws SemanticException {
        Type test = f.type.accept(this);
        functionEnvironment.add(f.id.name, test);
        return null;
    }
	public Type visit (FormalParameterList fpl) throws SemanticException {
        return null;
    }
	public Type visit (Identifier i) throws SemanticException {
        if(!variableEnvironment.inCurrentScope(i.name)){
            throw new SemanticException("Symbol not found --> " + i.name, i.line_number, i.offset);
        }
        return variableEnvironment.lookup(i.name);
    }
	public Type visit (IdentifierValue v) throws SemanticException {
        return v.id.accept(this);
    }
	public Type visit (IfStatement i) throws SemanticException {
        return null;
    }
	public Type visit (IntegerLiteral i) throws SemanticException {
        return new IntegerType();
    }
	public Type visit (LessThanExpression e) throws SemanticException {
        Type t1 = e.expr1.accept(this);
        Type t2 = e.expr2.accept(this);
        
        if(t1.equals(new IntegerType()) || t1.equals(new FloatType())){
            if(t1.equals(t2)){
                return t1;
            }
            else{
                throw new SemanticException("Mismatched types in mult --> " + t1 + ", " + t2, 
                                                e.line_number, e.offset);
            }
        }
        else{
            throw new SemanticException("Invalid type in mult --> " + t1,
                                            e.line_number, e.offset);
        }
    }
	public Type visit (MultExpression e) throws SemanticException {
        Type t1 = e.expr1.accept(this);
        Type t2 = e.expr2.accept(this);
        
        if(t1.equals(new IntegerType()) || t1.equals(new FloatType())){
            if(t1.equals(t2)){
                return t1;
            }
            else{
                throw new SemanticException("Mismatched types in mult --> " + t1 + ", " + t2, 
                                                e.line_number, e.offset);
            }
        }
        else{
            throw new SemanticException("Invalid type in mult --> " + t1,
                                            e.line_number, e.offset);
        }
    }
	public Type visit (ParenExpression p) throws SemanticException {
        return p.expr.accept(this);
    }
	public Type visit (PrintLnStatement s) throws SemanticException {
        return null;
    }
	public Type visit (PrintStatement s) throws SemanticException {
        return null;
    }	
	public Type visit (Program p) throws SemanticException {
        int size = p.size();
        for(int i=0; i < size; i++){
            p.elementAt(i).accept(this);
        }
        return null;
    }
	public Type visit (ReturnStatement s) throws SemanticException {
        return null;
    }
	public Type visit (StringLiteral s) throws SemanticException {
        return null;
    }
	public Type visit (SubtractExpression e) throws SemanticException {
        return null;
    }
    public Type visit (UnaryExpression e) throws SemanticException {
        return null;
    }
	public Type visit (Type t) throws SemanticException {
        return null;
    }
	public Type visit (TypeNode t) throws SemanticException {
        return t.type;
    }
	public Type visit (VariableAssignment s) throws SemanticException {
        Type varType = variableEnvironment.lookup(s.id.name);
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
        return null;
    }
	public Type visit (WhileStatement s) throws SemanticException {
        return null;
    }
}

