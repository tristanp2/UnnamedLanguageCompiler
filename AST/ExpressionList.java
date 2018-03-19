package AST;
import Types.*;
import Visitor.*;
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

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
