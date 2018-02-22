package AST;

public class FormalParameter extends ASTNode{
    TypeNode type;
    Identifier id;

    public FormalParameter(TypeNode t, Identifier i){
        type = t;
        id = i;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

