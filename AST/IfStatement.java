package AST;

public class IfStatement extends Statement{
    Block ifBlock;
    Block elseBlock;
    Expression condition;

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

    public void accept(Visitor v){
        v.visit(this);
    }
}
