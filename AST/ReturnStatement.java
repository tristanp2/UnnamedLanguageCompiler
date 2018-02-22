package AST;

public class ReturnStatement extends Statement{
    Expression expr;

    public ReturnStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "return";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
