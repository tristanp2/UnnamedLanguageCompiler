package AST;
import Types.*;
import Visitor.*;

public class Identifier extends ASTNode{
    public String name;

    public Identifier(String n, int ln, int os){
        name = n;
        line_number = ln;
        offset = os;
    }
    
    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
}
