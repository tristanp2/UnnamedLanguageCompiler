package AST;


public class FunctionDeclaration extends Declaration{
    FormalParameterList paramList; 

    public FunctionDeclaration(TypeNode t, Identifier i, FormalParameterList pl){
        type = t;
        id = i;
        paramList = pl;
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}

