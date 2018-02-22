package AST;

public class StringLiteral extends Expression{
    String val;

    public StringLiteral(String v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}    
