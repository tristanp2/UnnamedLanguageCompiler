package AST;

public class ExpressionStatement extends Statement{
    Expression expr;

    public ExpressionStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
