package AST;

public class VariableDeclaration extends Declaration{
    public VariableDeclaration(TypeNode t, Identifier i){
        type = t;
        line_number = t.line_number;
        offset = t.offset;
        id = i;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
        
