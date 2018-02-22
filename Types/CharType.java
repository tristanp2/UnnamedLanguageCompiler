package Types;
import AST.Visitor;

public class CharType extends Type{
    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return "char";
    }

    public boolean equals(Object o){
        return o instanceof CharType;
    }
}
