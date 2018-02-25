package AST;
import Print.*;

public class VariableAssignment extends AssignmentStatement{
    public VariableAssignment(Identifier i, Expression e){
        id = i;
        expr = e;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
