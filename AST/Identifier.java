package AST;

public class Identifier extends ASTNode{
    String name;

    public Identifier(String n, int ln, int os){
        name = n;
        line_number = ln;
        offset = os;
    }
    
    public void accept(Visitor v){
        v.visit(this);
    }
}
