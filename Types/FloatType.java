package Types;
import Visitor.*;

public class FloatType extends Type{
    public void accept(VoidVisitor v){
        v.visit(this);
    }

    public String toString(){
        return "float";
    }

    public boolean equals(Object o){
        return o instanceof FloatType;
    }
}

