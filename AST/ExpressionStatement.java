package AST;
import Print.*;

public class ExpressionStatement extends Statement{
    public Expression expr;

    public ExpressionStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "";
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
