package AST;
import Types.*;
import Visitor.*;

public class IdentifierValue extends Expression{
    public Identifier id;

    public IdentifierValue(Identifier i){
        id = i;
        this.line_number = i.line_number;
        this.offset = i.offset;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
