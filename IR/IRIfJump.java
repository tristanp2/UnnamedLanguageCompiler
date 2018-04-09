package IR;

public class IRIfJump extends IRInstruction {
    public TempVariable operand;
    public IRLabel dest;

    public IRIfJump(TempVariable o, IRLabel d) {
        operand = o;
        dest = d;
        instructionType = IRInstructionType.IFJUMP;
    }

    public String toString() {
        return String.format("IF %s GOTO %s;", operand, dest.labelName());
    }
    public String toStringAssembly() {
        return "";   
    }
}
