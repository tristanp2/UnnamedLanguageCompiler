package AST;
import Types.*;
import Visitor.*;
import Types.*;

public class TypeNode extends ASTNode{
    public Type type;

    public TypeNode(Type t, int ln, int os){
        type = t;
        line_number = ln;
        offset = os;
    }

    public Type getType() {
        return type;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
}
