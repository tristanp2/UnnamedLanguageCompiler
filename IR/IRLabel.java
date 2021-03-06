package IR;

public class IRLabel extends IRInstruction{
    Integer labelNum;

    public IRLabel(int ln) {
        labelNum = ln;
        instructionType = IRInstructionType.LABEL;
    }
    public String labelName() {
        return "L" + labelNum;
    }
    public String toString() {
        return labelName() + ":;"; 
    }
    public String toStringAssembly() {
        return "";   
    }
}
