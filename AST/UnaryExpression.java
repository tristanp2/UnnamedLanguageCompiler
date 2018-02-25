package AST;
import Print.*;

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
}

        
