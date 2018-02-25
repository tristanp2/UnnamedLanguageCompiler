package AST;
import Print.*;

public class EmptyStatement extends Statement{
    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public String toString(){
        return "";
    }
}
