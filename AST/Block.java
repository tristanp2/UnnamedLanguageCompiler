package AST;
import Types.*;
import Visitor.*;
import java.util.Vector;

public class Block extends ASTNode{
    public Vector statements;

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

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
