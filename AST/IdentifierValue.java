package AST;
import Print.*;

public class IdentifierValue extends Expression{
    public Identifier id;

    public IdentifierValue(Identifier i){
        id = i;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
