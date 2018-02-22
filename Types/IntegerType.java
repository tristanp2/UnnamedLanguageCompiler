package Types;
import AST.Visitor;

public class IntegerType extends Type{
    public void accept(Visitor v){
        v.visit(this);
    }

    public String toString(){
        return "int";
    }
    
    public boolean equals(Object o){
        return o instanceof IntegerType;
    }
}
