package AST;
import Visitor.*;

public abstract class Declaration extends ASTNode{
    public TypeNode type;
    public Identifier id;
}
