package AST;
import Types.*;
import Visitor.*;

public class PrintLnStatement extends Statement{
    public Expression expr;

    public PrintLnStatement(Expression e, int ln, int os){
        expr = e;
        line_number = ln;
        offset = os;
    }

    public String toString(){
        return "println";
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
