
package AST;

public class FloatLiteral extends Expression{
    Float val;

    public FloatLiteral(Float v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}    
