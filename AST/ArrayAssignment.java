package AST;
import Types.*;
import Visitor.*;

public class ArrayAssignment extends AssignmentStatement{
    public Expression index;

    public ArrayAssignment(Identifier i, Expression ind, Expression e){
        id = i;
        index = ind;
        expr = e;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
}
