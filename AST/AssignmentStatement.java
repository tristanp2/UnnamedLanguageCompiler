package AST;
import Visitor.*;

public abstract class AssignmentStatement extends Statement{
    public Identifier id;
    public Expression expr;
    public String toString(){
        return "";
    }
}
   
