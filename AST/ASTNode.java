package AST;
import Types.*;
import Visitor.*;
import Types.*;

public abstract class ASTNode{
    public int line_number;
    public int offset;
    public abstract Object accept(BaseVisitor v) throws Exception;
    public abstract Type accept(TypeVisitor v) throws SemanticException;
}
