package Types;
import Visitor.*;

public abstract class Type{
    public TypeEnum typeEnum;
    public abstract void accept(VoidVisitor v);
    public abstract String toStringUL();
    public abstract String toStringIR();
    public abstract String toString();
    public abstract boolean equals (TypeEnum te);
    public abstract boolean equals (Type t);
}
