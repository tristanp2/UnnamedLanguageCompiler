package AST;
import Types.*;
import Visitor.*;
import java.util.Vector;

public class MultExpression extends Expression{
    Vector expressions;
    public Expression expr1;
    public Expression expr2;

    public MultExpression(Expression e1, Expression e2){
        expr1 = e1;
        expr2 = e2;
        this.line_number = e1.line_number;
        this.offset = e1.offset;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
}
