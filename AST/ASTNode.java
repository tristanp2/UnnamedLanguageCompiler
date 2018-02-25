package AST;
import Types.*;
import Visitor.*;
import Types.*;

public abstract class ASTNode{
    public int line_number;
    public int offset;
    public abstract void accept(VoidVisitor v);
    public abstract Type accept(TypeVisitor v) throws SemanticException;
}
