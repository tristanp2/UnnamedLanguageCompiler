package AST;
import Types.*;
import Visitor.*;

public class FormalParameter extends ASTNode{
    public TypeNode type;
    public Identifier id;

    public FormalParameter(TypeNode t, Identifier i){
        type = t;
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
