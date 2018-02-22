package AST;

public class VariableAssignment extends AssignmentStatement{
    public VariableAssignment(Identifier i, Expression e){
        id = i;
        expr = e;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
