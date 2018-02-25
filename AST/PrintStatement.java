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

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
