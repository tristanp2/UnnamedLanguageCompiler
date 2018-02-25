package AST;
import Types.*;
import Visitor.*;
import Types.Type;

public abstract class AssignmentStatement extends Statement{
    public Identifier id;
    public Expression expr;
    public String toString(){
        return "";
    }
}
