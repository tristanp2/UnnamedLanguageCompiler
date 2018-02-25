package AST;
import Print.*;

public class ReturnStatement extends Statement{
    public Expression expr;

    public ReturnStatement(Expression e){
        expr = e;
    }

    public String toString(){
        return "return";
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
