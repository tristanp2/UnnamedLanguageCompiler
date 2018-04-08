package IR;

public class IRPrintLn extends IRInstruction {
    TempVariable temp;

    public IRPrintLn(TempVariable t){
        temp = t;
    }
    public String toString(){
        return String.format("PRINTLN%s %s;",temp.type.toStringIR(), temp);
    }
    public String toStringAssembly() {
        return "";   
    }
}
