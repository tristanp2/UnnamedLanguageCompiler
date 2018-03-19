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
        this.line_number = e.line_number;
        this.offset = e.offset;
    }
    public boolean negated(){
        return negate;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }

    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
