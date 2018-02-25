package AST;
import Visitor.*;

public class IfStatement extends Statement{
    public Block ifBlock;
    public Block elseBlock;
    public Expression condition;

    public IfStatement(Expression c, Block ib, Block eb){
        condition = c;
        ifBlock = ib;
        elseBlock = eb;
    }
    public IfStatement(Expression c, Block ib){
        this(c, ib, null);
    }
    
    public String toString(){
        return "if";
    }
    public boolean hasElse(){
        return elseBlock != null;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
