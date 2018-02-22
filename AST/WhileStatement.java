package AST;

public class WhileStatement extends Statement{
    Expression condition;
    Block body;

    public WhileStatement(Expression c, Block b){
        condition = c;
        body = b;
    }
    public String toString(){
        return "while";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
