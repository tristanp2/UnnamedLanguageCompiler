package AST;
import Print.*;

public class FunctionCall extends Expression{
    public Identifier id;
    public ExpressionList exprList;

    public FunctionCall(Identifier i, ExpressionList el){
        id = i;
        exprList = el;
        line_number = i.line_number;
        offset = i.offset;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}

