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

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
