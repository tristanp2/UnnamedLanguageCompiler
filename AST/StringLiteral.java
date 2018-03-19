package AST;
import Types.*;
import Visitor.*;

public class StringLiteral extends Expression{
    public String val;

    public StringLiteral(String v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
