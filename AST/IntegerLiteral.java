package AST;
import Types.*;
import Visitor.*;

public class IntegerLiteral extends Expression{
    public Integer val;

    public IntegerLiteral(Integer v, int ln, int os){
        val = v;
    }
    public int getVal(){
        return val;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
