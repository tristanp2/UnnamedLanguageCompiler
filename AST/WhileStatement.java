package AST;
import Types.*;
import Visitor.*;

public class WhileStatement extends Statement{
    public Expression condition;
    public Block body;

    public WhileStatement(Expression c, Block b, int ln, int os){
        condition = c;
        body = b;
        line_number = ln;
        offset = os;
    }
    public String toString(){
        return "while";
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
}
