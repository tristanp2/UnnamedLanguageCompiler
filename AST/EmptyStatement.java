package AST;

public class EmptyStatement extends Statement{
    public void accept(Visitor v){
        v.visit(this);
    }
    public String toString(){
        return "";
    }
}
