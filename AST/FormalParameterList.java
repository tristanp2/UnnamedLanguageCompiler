package AST;
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

    public void accept(Visitor v){
        v.visit(this);
    }
}
