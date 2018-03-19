package Types;
import Visitor.*;

public class BooleanType extends Type{
    public BooleanType() {
        typeEnum = TypeEnum.BOOLEAN;
    }
    public Object accept(BaseVisitor v) throws Exception{
        return v.visit(this);
    }
    public String toString(){
        return toStringUL();
    }
    public String toStringUL(){
        return "boolean";
    }
    public String toStringIR() {
        return "Z";
    }
    public boolean equals(TypeEnum te) {
        return te == typeEnum;
    }
    public boolean equals(Type t){
        return t.typeEnum == typeEnum;
    }
}
