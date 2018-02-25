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

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
