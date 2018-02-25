package AST;
import Print.*;

public class Identifier extends ASTNode{
    public String name;

    public Identifier(String n, int ln, int os){
        name = n;
        line_number = ln;
        offset = os;
    }
    
    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
