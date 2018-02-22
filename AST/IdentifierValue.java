package AST;

public class IdentifierValue extends Expression{
    Identifier id;

    public IdentifierValue(Identifier i){
        id = i;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
