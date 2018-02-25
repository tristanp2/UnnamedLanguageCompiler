package AST;
import Print.*;
import java.util.Vector;

public class LessThanExpression extends Expression{
    Vector expressions;
    public Expression expr1;
    public Expression expr2;

    public LessThanExpression(){
        expressions = new Vector();
    }
    public void addElement(Expression e){
        expressions.addElement(e);
    }
    public Expression elementAt(int index){
        return (Expression)expressions.elementAt(index);
    }
    public int size(){
        return expressions.size();
    }
    public LessThanExpression(Expression e1, Expression e2){
        expr1 = e1;
        expr2 = e2;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
