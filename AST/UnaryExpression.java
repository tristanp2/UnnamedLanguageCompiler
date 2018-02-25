package AST;
import Types.*;
import Visitor.*;

//wait... are these even allowed???
public class UnaryExpression extends Expression{
    public Expression expr;
    public Boolean negate;

    public UnaryExpression(Expression e, Boolean n){
        expr = e;
        negate = n;
    }
    public boolean negated(){
        return negate;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }

    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
