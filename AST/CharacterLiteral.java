package AST;

public class CharacterLiteral extends Expression{
    Character val;

    public CharacterLiteral(Character v, int ln, int os){
        val = v;
        line_number = ln;
        offset = os;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}    
