package AST;
import Visitor.*;
import java.util.Vector;

public class MultExpression extends Expression{
    Vector expressions;
    public Expression expr1;
    public Expression expr2;

    public MultExpression(){
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
    public MultExpression(Expression e1, Expression e2){
        expr1 = e1;
        expr2 = e2;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
