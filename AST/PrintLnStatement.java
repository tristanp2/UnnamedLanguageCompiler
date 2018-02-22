package AST;

public class PrintLnStatement extends Statement{
    Expression expr;

    public PrintLnStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "println";
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
