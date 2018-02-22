package AST;
import Types.*;

public class TypeNode extends ASTNode{
    Type type;

    public TypeNode(Type t, int ln, int os){
        type = t;
        line_number = ln;
        offset = os;
    }
    public Type getType(){
        return type;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
