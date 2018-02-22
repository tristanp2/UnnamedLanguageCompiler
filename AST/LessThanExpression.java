package AST;
import java.util.Vector;

public class LessThanExpression extends Expression{
    Vector expressions;

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

    public void accept(Visitor v){
        v.visit(this);
    }
}
