package Types;
import Visitor.*;

public class IntegerType extends Type{
    public IntegerType() {
        typeEnum = TypeEnum.INTEGER;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }

    public String toString(){
        return toStringUL();
    }
    public String toStringUL(){
        return "int";
    }
    public String toStringIR(){
        return "I";
    }
    public boolean equals(TypeEnum te){
        return te == typeEnum;
    }
    public boolean equals(Type t){
        return t.typeEnum == typeEnum;
    }
}
