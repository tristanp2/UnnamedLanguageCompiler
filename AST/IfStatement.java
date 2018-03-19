package AST;
import Types.*;
import Visitor.*;

public class IfStatement extends Statement{
    public Block ifBlock;
    public Block elseBlock;
    public Expression condition;

    public IfStatement(Expression c, Block ib, Block eb, int ln, int os){
        condition = c;
        ifBlock = ib;
        elseBlock = eb;
        line_number = ln;
        offset = os;
    }
    public IfStatement(Expression c, Block ib, int ln, int os){
        this(c, ib, null, ln, os);
    }
    
    public String toString(){
        return "if";
    }
    public boolean hasElse(){
        return elseBlock != null;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
