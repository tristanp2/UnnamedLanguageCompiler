package AST;
import Print.*;

public abstract class AssignmentStatement extends Statement{
    public Identifier id;
    public Expression expr;
    public String toString(){
        return "";
    }
}
   
