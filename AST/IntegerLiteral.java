package AST;
import Types.*;
import Visitor.*;

public class IntegerLiteral extends Expression{
    public Integer val;

    public IntegerLiteral(Integer v, int ln, int os){
        val = v;
    }
    public int getVal(){
        return val;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public String toString() {
        return val.toString();
    }
}
