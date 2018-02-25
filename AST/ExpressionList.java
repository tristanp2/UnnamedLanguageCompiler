package AST;
import Print.*;
import java.util.Vector;

public class ExpressionList extends ASTNode{
    Vector exprList;

    public ExpressionList(){
        exprList = new Vector();
    }

    public void addElement(Expression e){
        exprList.addElement(e);
    }
    public Expression elementAt(int index){
        return (Expression)exprList.elementAt(index);
    }
    public int size(){
        return exprList.size();
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
