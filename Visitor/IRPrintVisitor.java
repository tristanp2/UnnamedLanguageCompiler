package Visitor;
import IR.*;
import Types.*;
import AST.*;
import java.io.*;


public class IRPrintVisitor implements BaseVisitor{
    TempHandler tempHandler;
    IRProgram irp;
    IRFunction currentFunction;
    PrintStream out;
    String progName;
    int labelCount;

    public IRPrintVisitor(String pn, OutputStream os){
        out = new PrintStream(os);
        progName = pn;
        labelCount = 0;
    }

    public TempVariable visit(AddExpression ae) throws Exception{
        TempVariable tempE1;
        TempVariable tempE2;

        tempE1 = (TempVariable)ae.expr1.accept(this);
        if(ae.expr2 != null){
            tempE2 = (TempVariable)ae.expr2.accept(this);
            TempVariable destOperand = currentFunction.addTemp(tempE1.type);

            currentFunction.addInstruction(new IRAssignmentBinaryOp(destOperand, tempE1, "+", tempE2)); 
            return destOperand;
        }
        else {
            return tempE1;
        }
    }
    public TempVariable visit(ArrayAssignment aa) throws Exception{
        return null;
    }
    public TempVariable visit(ArrayReference ar) throws Exception{
        return null;
    }
    public TempVariable visit(Block b) throws Exception{
        int size = b.size();
        for(int i=0; i<size; i++){
            b.elementAt(i).accept(this);
        }
        return null;
    }
    public TempVariable visit(BooleanLiteral bl) throws Exception{
        String litVal = bl.toString().toUpperCase();
        TempVariable temp = currentFunction.lookupLiteral(litVal, new BooleanType());
        if(temp == null){
            temp = currentFunction.addLiteral(litVal, new BooleanType());
            currentFunction.addInstruction(new IRAssignmentConstant(temp, litVal));
        }
        return temp;
    }
    public TempVariable visit(CharacterLiteral cl) throws Exception{
        String litVal = cl.toString();
        TempVariable temp = currentFunction.lookupLiteral(litVal, new CharType());
        if(temp == null){
            temp = currentFunction.addLiteral(litVal, new CharType());
            currentFunction.addInstruction(new IRAssignmentConstant(temp, litVal));
        }
        return temp;
    }
    public TempVariable visit(EmptyStatement es) throws Exception{
        return null;
    }
    public TempVariable visit(EqualityExpression ee) throws Exception{
        TempVariable tempE1;
        TempVariable tempE2;

        tempE1 = (TempVariable)ee.expr1.accept(this);
        if(ee.expr2 != null){
            tempE2 = (TempVariable)ee.expr2.accept(this);
            TempVariable destOperand = currentFunction.addTemp("", tempE1.type);

            currentFunction.addInstruction(new IRAssignmentBinaryOp(destOperand, tempE1, "==", tempE2)); 
            return destOperand;
        }
        else {
            return tempE1;
        }

    }
    public TempVariable visit(ExpressionList el) throws Exception{
        return null;
    }
    public TempVariable visit(ExpressionStatement es) throws Exception{
        return null;
    }
    public TempVariable visit(FloatLiteral fl) throws Exception{
        String litVal = fl.toString();
        TempVariable temp = currentFunction.lookupLiteral(litVal, new FloatType());
        if(temp == null){
            temp = currentFunction.addLiteral(litVal, new FloatType());
            currentFunction.addInstruction(new IRAssignmentConstant(temp, litVal));
        }
        return temp;
    }
    public TempVariable visit(FormalParameter fp) throws Exception{
        return null;
    }
    public TempVariable visit(FormalParameterList fpl) throws Exception{
        return null;
    }
    public TempVariable visit(FunctionBody fb) throws Exception{
        int decSize = fb.declarationSize();
        for(int i = 0; i < decSize; i++) {
            fb.declarationAt(i).accept(this);
        }

        int statSize = fb.statementSize();
        for(int i = 0; i < statSize; i++) {
            fb.statementAt(i).accept(this);
        }
        return null;
    }
    public TempVariable visit(FunctionCall fc) throws Exception{
        return null;
    }
    public TempVariable visit(FunctionDeclaration fd) throws Exception{
        currentFunction.returnType = fd.type.type; //lol
        currentFunction.funcName = fd.id.name;
        return null;
    }
    public TempVariable visit(Function f) throws Exception{
        currentFunction = new IRFunction();
        f.funcDec.accept(this);
        f.funcBody.accept(this);
         
        return null;
    }
    public TempVariable visit(Identifier i) throws Exception{
        return null;
    }
    public TempVariable visit(IdentifierValue iv) throws Exception{
        TempVariable temp = currentFunction.lookupTemp(iv.id.name);
        
        if(temp == null){
            throw new Exception("iv undeclared??");
        }
        return temp;
    }
    public TempVariable visit(IfStatement is) throws Exception{
        IRLabel l1 = new IRLabel(labelCount++);

        TempVariable condTemp = (TempVariable)is.condition.accept(this);

        //could just invert condTemp, but that would cause problems
        //  if condition was just a boolean variable, and detecting that is inconvenient
        TempVariable invCondTemp = currentFunction.addTemp(new BooleanType());
        currentFunction.addInstruction(new IRAssignmentUnaryOp(invCondTemp, "!", condTemp));
        currentFunction.addInstruction(new IRIfJump(condTemp, l1));
        is.ifBlock.accept(this);

        if(is.hasElse()){
            IRLabel l2 = new IRLabel(labelCount++);
            currentFunction.addInstruction(new IRJump(l2));
            currentFunction.addInstruction(l1);
            is.elseBlock.accept(this);
            currentFunction.addInstruction(l2);
        }
        else{
            currentFunction.addInstruction(l1);
        }

        return null;
    }
    public TempVariable visit(IntegerLiteral il) throws Exception{
        String litVal = il.toString();
        TempVariable temp = currentFunction.lookupLiteral(litVal, new IntegerType());
        if(temp == null){
            temp = currentFunction.addLiteral(litVal, new IntegerType());
            currentFunction.addInstruction(new IRAssignmentConstant(temp, litVal));
        }
        return temp;
    }
    public TempVariable visit(LessThanExpression lte) throws Exception{
        TempVariable tempE1;
        TempVariable tempE2;

        tempE1 = (TempVariable)lte.expr1.accept(this);
        if(lte.expr2 != null){
            tempE2 = (TempVariable)lte.expr2.accept(this);
            TempVariable destOperand = currentFunction.addTemp("", tempE1.type);

            currentFunction.addInstruction(new IRAssignmentBinaryOp(destOperand, tempE1, "<", tempE2)); 
            return destOperand;
        }
        else{
            return tempE1;
        }
    }
    public TempVariable visit(MultExpression me) throws Exception{
        TempVariable tempE1;
        TempVariable tempE2;

        tempE1 = (TempVariable)me.expr1.accept(this);
        if(me.expr2 != null){
            tempE2 = (TempVariable)me.expr2.accept(this);
            TempVariable destOperand = currentFunction.addTemp(tempE1.type);

            currentFunction.addInstruction(new IRAssignmentBinaryOp(destOperand, tempE1, "*", tempE2)); 
            return destOperand;
        }
        else {
            return tempE1;
        }

    }
    public TempVariable visit(ParenExpression pe) throws Exception{
        return null;
    }
    public TempVariable visit(PrintLnStatement pls) throws Exception{
        return null;
    }
    public TempVariable visit(PrintStatement ps) throws Exception{
        return null;
    }
    public TempVariable visit(Program p) throws Exception{
        int size = p.size();
        out.println(progName);
        irp = new IRProgram();
        for(int i=0; i<size; i++){
            p.elementAt(i).accept(this);
            irp.addFunction(currentFunction);
        }
        out.println(irp);

        return null;
    }
    public TempVariable visit(ReturnStatement rs) throws Exception{
        return null;
    }
    public TempVariable visit(StringLiteral sl) throws Exception{
        String litVal = sl.toString();
        TempVariable temp = currentFunction.lookupLiteral(litVal, new StringType());
        if(temp == null){
            temp = currentFunction.addLiteral(litVal, new StringType());
            currentFunction.addInstruction(new IRAssignmentConstant(temp, litVal));
        }
        return temp;
    }
    public TempVariable visit(SubtractExpression se) throws Exception{
        TempVariable tempE1;
        TempVariable tempE2;

        tempE1 = (TempVariable)se.expr1.accept(this);
        
        if(se.expr2 != null){
            tempE2 = (TempVariable)se.expr2.accept(this);
            TempVariable destOperand = currentFunction.addTemp(tempE1.type);

            currentFunction.addInstruction(new IRAssignmentBinaryOp(destOperand, tempE1, "-", tempE2)); 
            return destOperand;
        }
        else {
            return tempE1;
        }

    }
    public TempVariable visit(TypeNode tn) throws Exception{
        return null;
    }
    public TempVariable visit(UnaryExpression ue) throws Exception{
        //TODO
        return (TempVariable)ue.expr.accept(this);
    }
    public TempVariable visit(VariableAssignment va) throws Exception{
        TempVariable destOperand = currentFunction.lookupTemp(va.id.name);
        TempVariable srcOperand;
        
        if(destOperand == null){
            throw new Exception("variable wasn't declared???");
        }

        srcOperand = (TempVariable)va.expr.accept(this);

        currentFunction.addInstruction(new IRAssignmentOperand(destOperand, srcOperand));
        
        return null;
    }
    public TempVariable visit(VariableDeclaration vd) throws Exception{
        TempVariable tempDecl = currentFunction.addTemp(vd.id.name, vd.type.type);

        return null;
    }
    public TempVariable visit(WhileStatement ws) throws Exception{
        IRLabel l1 = new IRLabel(labelCount++);
        IRLabel l2 = new IRLabel(labelCount++);

        currentFunction.addInstruction(l1);
        TempVariable condTemp = (TempVariable)ws.condition.accept(this);
        //could just invert condTemp, but that would cause problems
        //  if condition was just a boolean variable, and detecting that is inconvenient
        TempVariable invCondTemp = currentFunction.addTemp(new BooleanType());
        currentFunction.addInstruction(new IRAssignmentUnaryOp(invCondTemp, "!", condTemp));
        currentFunction.addInstruction(new IRIfJump(condTemp, l2));
        ws.body.accept(this);
        currentFunction.addInstruction(new IRJump(l1));

        return null;
    }
    public TempVariable visit(Type t) throws Exception{
        return null;
    }
    public TempVariable visit(ArrayType at) throws Exception{
        return null;
    }
    public TempVariable visit(BooleanType bt) throws Exception{
        return null;
    }
    public TempVariable visit(CharType ct) throws Exception{
        return null;
    }
    public TempVariable visit(FloatType ft) throws Exception{
        return null;
    }
    public TempVariable visit(IntegerType it) throws Exception{
        return null;
    }
    public TempVariable visit(StringType st) throws Exception{
        return null;
    }
    public TempVariable visit(VoidType vt) throws Exception{
        return null;
    }
}
