package AST;
import Types.*;
import Visitor.*;

public class VariableDeclaration extends Declaration{
    public VariableDeclaration(TypeNode t, Identifier i){
        type = t;
        line_number = t.line_number;
        offset = t.offset;
        id = i;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
