package AST;
import java.util.Vector;

public class Function extends ASTNode{
    FunctionDeclaration funcDec;
    FunctionBody funcBody;

    public Function(FunctionDeclaration fd, FunctionBody fb){
        funcDec = fd;
        funcBody = fb;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
    

