package AST;
import Types.*;
import Visitor.*;

public class ParenExpression extends Expression{
    public Expression expr;

    public ParenExpression(Expression e){
        expr = e;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
