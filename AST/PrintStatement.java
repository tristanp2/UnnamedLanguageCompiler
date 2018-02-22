package AST;

public class PrintStatement extends Statement{
    Expression expr;

    public PrintStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "print";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
