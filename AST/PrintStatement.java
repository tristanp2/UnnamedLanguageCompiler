package AST;
import Types.*;
import Visitor.*;

public class PrintStatement extends Statement{
    public Expression expr;

    public PrintStatement(Expression e, int ln, int os){
        expr = e;
        line_number = ln;
        offset = os;
    }

    public String toString(){
        return "print";
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
}
