package AST;
import Types.*;
import Visitor.*;


public class FunctionDeclaration extends Declaration{
    public FormalParameterList paramList; 

    public FunctionDeclaration(TypeNode t, Identifier i, FormalParameterList pl){
        type = t;
        id = i;
        paramList = pl;
        this.line_number = type.line_number;
        this.offset = type.offset;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
