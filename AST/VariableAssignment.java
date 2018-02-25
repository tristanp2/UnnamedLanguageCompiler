package AST;
import Types.*;
import Visitor.*;

public class VariableAssignment extends AssignmentStatement{
    public VariableAssignment(Identifier i, Expression e){
        id = i;
        expr = e;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
