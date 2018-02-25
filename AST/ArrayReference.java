package AST;
import Types.*;
import Visitor.*;

public class ArrayReference extends Expression{
    public Identifier id;
    public Expression index;

    public ArrayReference(Identifier i, Expression e){
        id = i;
        index = e;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
