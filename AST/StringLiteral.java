package AST;
import Print.*;

public class StringLiteral extends Expression{
    public String val;

    public StringLiteral(String v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}    
