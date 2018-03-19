package AST;
import Types.*;
import Visitor.*;

public class EmptyStatement extends Statement{
    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
    public String toString(){
        return "";
    }
}
