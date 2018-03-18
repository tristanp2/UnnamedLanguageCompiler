package Types;
import Visitor.*;

public class StringType extends Type{
    public StringType() {
        typeEnum = TypeEnum.STRING;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public String toString(){
        return toStringUL();
    }
    public String toStringUL(){
        return "string";
    }
    public String toStringIR(){
        return "U";
    }
    public boolean equals(TypeEnum te){
        return te == typeEnum;
    }
    public boolean equals(Type t){
        return t.typeEnum == typeEnum;
    }
}
