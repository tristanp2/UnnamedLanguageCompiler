package AST;
import Types.*;
import Visitor.*;
import java.util.Vector;

public class FormalParameterList extends ASTNode{
    Vector paramList;

    public FormalParameterList(){
        paramList = new Vector();
    }

    public void addElement(FormalParameter fp){
        paramList.addElement(fp);
    }
    public FormalParameter elementAt(int index){
        return (FormalParameter)paramList.elementAt(index);
    }
    public int size(){
        return paramList.size();
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
