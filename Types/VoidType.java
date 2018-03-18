package Types;
import Visitor.*;

public class VoidType extends Type{
    public VoidType() {
        typeEnum = TypeEnum.VOID;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }
    
    public String toString() {
        return toStringUL();
    }
    public String toStringUL(){
        return "void";
    }
    public String toStringIR(){
        return "";
    }
    public boolean equals(TypeEnum te) {
        return te == typeEnum;
    }
    public boolean equals(Type t){
        return t.typeEnum == this.typeEnum;
    }
}
