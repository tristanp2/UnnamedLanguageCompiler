package AST;
import java.util.Vector;

public class EqualityExpression extends Expression{
    Vector lessExpressions;

    public EqualityExpression(){
        lessExpressions = new Vector();
    }

    public void addElement(LessThanExpression e){
        lessExpressions.addElement(e);
    }
    public LessThanExpression elementAt(int index){
        return (LessThanExpression)lessExpressions.elementAt(index);
    }
    public int size(){
        return lessExpressions.size();
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
