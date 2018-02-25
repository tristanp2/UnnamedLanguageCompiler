package Types;
import Print.*;

public class IntegerType extends Type{
    public void accept(VoidVisitor v){
        v.visit(this);
    }

    public String toString(){
        return "int";
    }
    
    public boolean equals(Object o){
        return o instanceof IntegerType;
    }
}
