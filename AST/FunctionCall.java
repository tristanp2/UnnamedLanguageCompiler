package AST;
import Types.*;
import Visitor.*;

public class FunctionCall extends Expression{
    public Identifier id;
    public ExpressionList exprList;

    public FunctionCall(Identifier i, ExpressionList el){
        id = i;
        exprList = el;
        line_number = i.line_number;
        offset = i.offset;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
