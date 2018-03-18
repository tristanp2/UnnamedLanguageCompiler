package Types;
import Visitor.*;

public class CharType extends Type{
    public CharType() {
        typeEnum = TypeEnum.CHAR;
    }
    public void accept(VoidVisitor v){
        v.visit(this);
    }
    public String toString(){
        return toStringUL();
    }
    public String toStringUL(){
        return "char";
    }
    public String toStringIR(){
        return "C";
    }
    public boolean equals(TypeEnum te){
        return te == typeEnum;
    }
    public boolean equals(Type t){
        return t.typeEnum == this.typeEnum;
    }
}
