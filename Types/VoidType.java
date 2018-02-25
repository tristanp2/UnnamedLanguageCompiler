package Types;
import Visitor.*;

public class VoidType extends Type{
    public void accept(VoidVisitor v){
        v.visit(this);
    }

    public String toString(){
        return "void";
    }
    public boolean equals(Object o){
        return o instanceof VoidType;
    }
}
