package AST;
import Types.*;
import Visitor.*;

public class EmptyStatement extends Statement{
    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
    public String toString(){
        return "";
    }
}
