package AST;
import Visitor.*;
import Types.*;

public class TypeNode extends ASTNode{
    public Type type;

    public TypeNode(Type t, int ln, int os){
        type = t;
        line_number = ln;
        offset = os;
    }
    public Type getType(){
        return type;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
