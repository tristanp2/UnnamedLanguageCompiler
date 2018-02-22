package AST;

public class BooleanLiteral extends Expression{
    Boolean val;

    public BooleanLiteral(Boolean v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}    
