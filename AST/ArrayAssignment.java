package AST;
import Visitor.*;

public class ArrayAssignment extends AssignmentStatement{
    public Expression index;

    public ArrayAssignment(Identifier i, Expression ind, Expression e){
        id = i;
        index = ind;
        expr = e;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}
