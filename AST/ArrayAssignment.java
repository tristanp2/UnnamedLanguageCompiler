package AST;

public class ArrayAssignment extends AssignmentStatement{
    Expression index;

    public ArrayAssignment(Identifier i, Expression ind, Expression e){
        id = i;
        index = ind;
        expr = e;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
