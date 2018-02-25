package AST;
import Print.*;

public class BooleanLiteral extends Expression{
    public Boolean val;

    public BooleanLiteral(Boolean v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}    
