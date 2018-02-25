package AST;
import Types.*;
import Visitor.*;

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
    public Type accept(TypeVisitor tv) throws SemanticException{
        return tv.visit(this);
    }
}
