package IR;

public class IRPrint extends IRInstruction {
    public TempVariable operand;

    public IRPrint(TempVariable t){
        operand = t;
        instructionType = IRInstructionType.PRINT;
    }
    public String toString(){
        return String.format("PRINT%s %s;",operand.type.toStringIR(), operand);
    }
    public String toStringAssembly() {
        return "";   
    }
}
