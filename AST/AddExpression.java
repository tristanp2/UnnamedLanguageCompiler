package AST;
import Types.*;
import Visitor.*;
import java.util.Vector;

public class AddExpression extends Expression{
    public Expression expr1;
    public Expression expr2;

    public AddExpression(Expression e1,  Expression e2){
        expr1 = e1;
        expr2 = e2;
        this.line_number = e1.line_number;
        this.offset = e1.offset;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
