package Types;
import AST.Visitor;

public class VoidType extends Type{
    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return "void";
    }
    public boolean equals(Object o){
        return o instanceof VoidType;
    }
}
