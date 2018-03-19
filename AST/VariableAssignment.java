package AST;
import Types.*;
import Visitor.*;

public class VariableAssignment extends AssignmentStatement{
    public VariableAssignment(Identifier i, Expression e){
        id = i;
        expr = e;
        this.line_number = i.line_number;
        this.offset = i.offset;
    }

    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
