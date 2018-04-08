package IR;

public class IRPrint extends IRInstruction {
    TempVariable temp;

    public IRPrint(TempVariable t){
        temp = t;
    }
    public String toString(){
        return String.format("PRINT%s %s;",temp.type.toStringIR(), temp);
    }
    public String toStringAssembly() {
        return "";   
    }
}
