
package AST;

public class IntegerLiteral extends Expression{
    Integer val;

    public IntegerLiteral(Integer v, int ln, int os){
        val = v;
    }
    public int getVal(){
        return val;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}    
