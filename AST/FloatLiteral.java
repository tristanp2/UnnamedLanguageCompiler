package AST;
import Types.*;
import Visitor.*;

public class FloatLiteral extends Expression{
    public Float val;

    public FloatLiteral(Float v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public String toString() {
        return val.toString();
    }
}
