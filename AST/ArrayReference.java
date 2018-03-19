package AST;
import Types.*;
import Visitor.*;

public class ArrayReference extends Expression{
    public Identifier id;
    public Expression index;

    public ArrayReference(Identifier i, Expression e){
        id = i;
        index = e;
        this.line_number = i.line_number;
        this.offset = i.offset;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
}
