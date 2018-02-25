package Types;
import Print.*;

public abstract class Type{
    public abstract void accept(VoidVisitor v);
    public abstract String toString();
    public abstract boolean equals (Object o);
}