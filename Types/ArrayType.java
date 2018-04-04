package Types;
import Visitor.*;

public class ArrayType extends Type{
    public Type elementType;
    public int size;
    public ArrayType(Type et, int s){
        typeEnum = TypeEnum.ARRAY;
        elementType = et;
        size = s;
    }
    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }

    public String toString(){
        return toStringUL();
    }
    public String toStringUL(){
        return elementType.toStringUL() + "[" + size + "]";
    }
    public String toStringIR(){
        return  "A" + elementType.toStringIR(); 
    }
    public Type elementType(){
        return elementType;
    }
    public boolean equals (TypeEnum te) {
        return te == TypeEnum.ARRAY;
    }
    public boolean equals (Type t){
        if(t.typeEnum == typeEnum) {
            ArrayType at = (ArrayType)t;
            if(at.elementType.equals(elementType) && at.size == size)
                return true;
        }

        return false;
    }
}
