package AST;
import java.util.Vector;

public class FunctionBody extends ASTNode{
    Vector declarationList;
    Vector statementList;

    public FunctionBody(){
        declarationList = new Vector();
        statementList = new Vector();
    }

    public void addDeclaration(VariableDeclaration vd){
        declarationList.addElement(vd);
    }
    public VariableDeclaration declarationAt(int index){
        return (VariableDeclaration)declarationList.elementAt(index);
    }
    public int declarationSize(){
        return declarationList.size();
    }
    
    public void addStatement(Statement s){
        statementList.addElement(s);
    }
    public Statement statementAt(int index){
        return (Statement)statementList.elementAt(index);
    }
    public int statementSize(){
        return statementList.size();
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
