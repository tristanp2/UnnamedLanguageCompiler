package Types;
import AST.Visitor;

public class FloatType extends Type{
    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return "float";
    }

    public boolean equals(Object o){
        return o instanceof FloatType;
    }
}

