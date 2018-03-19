package AST;
import Types.*;
import Visitor.*;

public class EmptyStatement extends Statement{
    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public String toString(){
        return "";
    }
}
