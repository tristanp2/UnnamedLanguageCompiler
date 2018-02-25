package Visitor;

public class SemanticException extends Exception{
    String message;
    int line;
    int offset;

    public SemanticException(String m, int l, int os){
        message = m;
        line = l;
        offset = os;
    }

    public String toString(){
        return "Error on line " + line + " (" + offset + "): " + message;
    }
}

