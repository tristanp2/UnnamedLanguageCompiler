package Types;
import Visitor.*;

public class StringType extends Type{

    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public String toString(){
        return "string";
    }
    public boolean equals(Object o){
        return o instanceof StringType;
    }
}
