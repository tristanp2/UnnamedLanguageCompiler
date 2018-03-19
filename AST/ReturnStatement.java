package AST;
import Types.*;
import Visitor.*;

public class ReturnStatement extends Statement{
    public Expression expr;

    public ReturnStatement(Expression e, int ln, int os){
        expr = e;
        line_number = ln;
        offset = os;
    }

    public String toString(){
        return "return";
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
}
