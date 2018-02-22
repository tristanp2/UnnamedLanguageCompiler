package AST;

public class ArrayReference extends Expression{
    Identifier id;
    Expression index;

    public ArrayReference(Identifier i, Expression e){
        id = i;
        index = e;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
