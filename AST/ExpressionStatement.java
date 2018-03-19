package AST;
import Types.*;
import Visitor.*;

public class ExpressionStatement extends Statement{
    public Expression expr;

    public ExpressionStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "";
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
