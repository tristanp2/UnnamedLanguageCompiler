package AST;

//wait... are these even allowed???
public class UnaryExpression extends Expression{
    Expression expr;
    Boolean negate;

    public UnaryExpression(Expression e, Boolean n){
        expr = e;
        negate = n;
    }
    public boolean negated(){
        return negate;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

        
