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
    String litVal;

    public IRPrintVisitor(String pn, OutputStream os){
        out = new PrintStream(os);
        progName = pn;
    }

    public TempVariable visit(AddExpression ae) throws Exception{
        TempVariable tempE1;
        TempVariable tempE2;

        Type litCheck = getLiteralType(ae.e1);

        if(!litCheck == null){
            tempE1 = currentFunction.addTemp(litCheck);

            //this should assign to litVal
            ae.e1.accept(this);

            currentFunction.addInstruction(new IRAssignmentConstant(t, litVal));
        }
        else{
            tempE1 = ae.e1.accept(this);
        }
        
        litCheck = getLiteralType(ae.e2);
        if(!litCheck == null){
            tempE2 = currentFunction.addTemp(litCheck);

            ae.e2.accept(this);

            currentFunction.addInstruction(new IRAssignmentConstant(t, litVal));
        }
        else{
            tempE2 = ae.e2.accept(this);
        }

        TempVariable destOperand = currentFunction.addTemp(tempE1.type);

        currentFunction.addInstruction(new IRAssignmentBinaryOp(destOperand, tempE1, "+", tempE2)); 
        return destOperand;
    }
    public TempVariable visit(ArrayAssignment aa) throws Exception{
        return null;
    }
    public TempVariable visit(ArrayReference ar) throws Exception{
        return null;
    }
    public TempVariable visit(Block b) throws Exception{
        return null;
    }
    public TempVariable visit(BooleanLiteral bl) throws Exception{
        litVal = bl.toString();
        return null;
    }
    public TempVariable visit(CharacterLiteral cl) throws Exception{
        litVal = cl.toString();
        return null;
    }
    public TempVariable visit(EmptyStatement es) throws Exception{
        return null;
    }
    public TempVariable visit(EqualityExpression ee) throws Exception{
        return null;
    }
    public TempVariable visit(ExpressionList el) throws Exception{
        return null;
    }
    public TempVariable visit(ExpressionStatement es) throws Exception{
        return null;
    }
    public TempVariable visit(FloatLiteral fl) throws Exception{
        litVal = fl.toString();
        return null;
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
        literalCount = 0;
        currentFunction = new IRFunction();
        f.funcDec.accept(this);
        f.funcBody.accept(this);
         
        return null;
    }
    public TempVariable visit(Identifier i) throws Exception{
        return null;
    }
    public TempVariable visit(IdentifierValue iv) throws Exception{
        return null;
    }
    public TempVariable visit(IfStatement is) throws Exception{
        return null;
    }
    public TempVariable visit(IntegerLiteral il) throws Exception{
        litVal = il.toString();
        return null;
    }
    public TempVariable visit(LessThanExpression lte) throws Exception{
        return null;
    }
    public TempVariable visit(MultExpression me) throws Exception{
        return null;
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
        litVal = sl.toString();
        return null;
    }
    public TempVariable visit(SubtractExpression se) throws Exception{
        return null;
    }
    public TempVariable visit(TypeNode tn) throws Exception{
        return null;
    }
    public TempVariable visit(UnaryExpression ue) throws Exception{
        return null;
    }
    public TempVariable visit(VariableAssignment va) throws Exception{
        return null;
    }
    public TempVariable visit(VariableDeclaration vd) throws Exception{
        return null;
    }
    public TempVariable visit(WhileStatement ws) throws Exception{
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

    private Type getLiteralType(ASTNode n) {
        if(n instanceof BooleanLiteral){
            return new BooleanType();
        }
        else if(n instanceof CharLiteral){
            return new CharType();
        }
        else if(n instanceof FloatLiteral){
            return new FloatType();
        }
        else if(n instanceof IntegerLiteral){
            return new IntegerType();
        }
        else if(n instanceof StringLiteral){
            return new StringType();
        }
        else{
            return null;
        }
    }
}
