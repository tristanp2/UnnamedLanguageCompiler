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

    public IRPrintVisitor(String pn, OutputStream os){
        out = new PrintStream(os);
        progName = pn;
    }

    public TempVariable visit(AddExpression ae) throws Exception{

        return null;
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
        return null;
    }
    public TempVariable visit(CharacterLiteral cl) throws Exception{
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
        return null;
    }
    public TempVariable visit(FormalParameter fp) throws Exception{
        return null;
    }
    public TempVariable visit(FormalParameterList fpl) throws Exception{
        return null;
    }
    public TempVariable visit(FunctionBody fb) throws Exception{
        return null;
    }
    public TempVariable visit(FunctionCall fc) throws Exception{
        return null;
    }
    public TempVariable visit(FunctionDeclaration fd) throws Exception{
        return null;
    }
    public TempVariable visit(Function f) throws Exception{
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
        for(int i=0; i<size; i++){
            p.elementAt(i).accept(this);
            return null;
    }
        return null;
    }
    public TempVariable visit(ReturnStatement rs) throws Exception{
        return null;
    }
    public TempVariable visit(StringLiteral sl) throws Exception{
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
}
