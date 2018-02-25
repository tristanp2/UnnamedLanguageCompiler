package AST;
import Print.*;

public class FloatLiteral extends Expression{
    public float val;

    public FloatLiteral(Float v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}    
