package AST;
import java.util.Vector;

public class MultExpression extends Expression{
    Vector unaryExpressions;

    public MultExpression(){
        unaryExpressions = new Vector();
    }

    public void addElement(UnaryExpression e){
        unaryExpressions.addElement(e);
    }
    public UnaryExpression elementAt(int index){
        return (UnaryExpression)unaryExpressions.elementAt(index);
    }
    public int size(){
        return unaryExpressions.size();
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
