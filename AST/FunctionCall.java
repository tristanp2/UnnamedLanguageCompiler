package AST;

public class FunctionCall extends Expression{
    Identifier id;
    ExpressionList exprList;

    public FunctionCall(Identifier i, ExpressionList el){
        id = i;
        exprList = el;
        line_number = i.line_number;
        offset = i.offset;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}

