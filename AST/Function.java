package AST;
import Print.*;
import java.util.Vector;

public class Function extends ASTNode{
    public FunctionDeclaration funcDec;
    public FunctionBody funcBody;

    public Function(FunctionDeclaration fd, FunctionBody fb){
        funcDec = fd;
        funcBody = fb;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
    

