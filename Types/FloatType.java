package Types;
import Visitor.*;

public class FloatType extends Type{
    public FloatType() {
        typeEnum = TypeEnum.FLOAT;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }

    public String toString(){
        return toStringUL();
    }
    public String toStringUL(){
        return "float";
    }
    public String toStringIR(){
        return "F";
    }

    public boolean equals(TypeEnum te){
        return te == typeEnum;
    }

    public boolean equals(Type t){
        return t.typeEnum == this.typeEnum;
    }
}

