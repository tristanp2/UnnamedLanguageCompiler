package AST;
import Print.*;

public class FormalParameter extends ASTNode{
    public TypeNode type;
    public Identifier id;

    public FormalParameter(TypeNode t, Identifier i){
        type = t;
        id = i;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}

