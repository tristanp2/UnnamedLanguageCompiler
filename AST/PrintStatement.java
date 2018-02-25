package AST;
import Print.*;

public class PrintStatement extends Statement{
    public Expression expr;

    public PrintStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "print";
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
