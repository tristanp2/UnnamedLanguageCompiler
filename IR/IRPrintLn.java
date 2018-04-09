package IR;

public class IRPrintLn extends IRInstruction {
    public TempVariable operand;

    public IRPrintLn(TempVariable t){
        operand = t;
        instructionType = IRInstructionType.PRINTLN;
    }
    public String toString(){
        return String.format("PRINTLN%s %s;",operand.type.toStringIR(), operand);
    }
    public String toStringAssembly() {
        return "";   
    }
}
