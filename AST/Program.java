package AST;
import Types.*;
import Visitor.*;
import java.util.Vector;

public class Program extends ASTNode{
    Vector functionList;

    public Program(){
        functionList = new Vector();
    }

    public void addElement(Function f){
        functionList.addElement(f);
    }

    public Function elementAt(int index){
        return (Function)functionList.elementAt(index);
    }

    public int size(){
        return functionList.size();
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
