package AST;
import Print.*;

public class WhileStatement extends Statement{
    public Expression condition;
    public Block body;

    public WhileStatement(Expression c, Block b){
        condition = c;
        body = b;
    }
    public String toString(){
        return "while";
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
