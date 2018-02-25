package AST;
import Visitor.*;

public class PrintLnStatement extends Statement{
    public Expression expr;

    public PrintLnStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "println";
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
