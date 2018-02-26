package Types;
import Visitor.*;

public class ArrayType extends Type{
    Type elementType;
    int size;
    public ArrayType(){
        }
    public ArrayType(Type et, int s){
        elementType = et;
        size = s;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }

    public String toString(){
        return elementType.toString() + "[" + Integer.toString(size) + "]";
    }
    public Type elementType(){
        return elementType;
    }
    public boolean equals (Object o){
        if(o instanceof ArrayType)
            if(((ArrayType)o).elementType == elementType && ((ArrayType)o).size == size)
                return true;

        return false;
    }
}
