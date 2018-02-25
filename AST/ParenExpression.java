package AST;
import Print.*;

public class ParenExpression extends Expression{
    public Expression expr;

    public ParenExpression(Expression e){
        expr = e;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
