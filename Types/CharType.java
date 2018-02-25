package Types;
import Print.*;

public class CharType extends Type{
    public void accept(VoidVisitor v){
        v.visit(this);
    }

    public String toString(){
        return "char";
    }

    public boolean equals(Object o){
        return o instanceof CharType;
    }
}
