package AST;
import Print.*;

public abstract class ASTNode{
    public int line_number;
    public int offset;
    public abstract void accept(VoidVisitor v);
    public int getLineNum(){
        return line_number;
    }
    public int getOffset(){
        return offset;
    }
}
