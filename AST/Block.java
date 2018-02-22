package AST;
import java.util.Vector;

public class Block extends ASTNode{
    Vector statements;

    public Block(){
        statements = new Vector();
    }

    public void addElement(Statement s){
        statements.addElement(s);
    }
    public Statement elementAt(int index){
        return (Statement)statements.elementAt(index);
    }
    public int size(){
        return statements.size();
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
