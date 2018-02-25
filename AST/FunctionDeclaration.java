package AST;
import Print.*;


public class FunctionDeclaration extends Declaration{
    public FormalParameterList paramList; 

    public FunctionDeclaration(TypeNode t, Identifier i, FormalParameterList pl){
        type = t;
        id = i;
        paramList = pl;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }
}

