package AST;

public abstract class ASTNode{
    int line_number;
    int offset;
    public abstract void accept(Visitor v);
    public int getLineNum(){
        return line_number;
    }
    public int getOffset(){
        return offset;
    }
}
