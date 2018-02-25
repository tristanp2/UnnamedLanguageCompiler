package AST;
import Print.*;

public class CharacterLiteral extends Expression{
    public Character val;

    public CharacterLiteral(Character v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public void accept(VoidVisitor v){
        v.visit(this);
    }
}    