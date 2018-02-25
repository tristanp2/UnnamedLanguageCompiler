package AST;
import Print.*;
import java.util.Vector;

public class SubtractExpression extends Expression{
    public Expression expr1;
    public Expression expr2;

    public SubtractExpression(Expression e1, Expression e2){
        expr1 = e1;
        expr2 = e2;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }
}