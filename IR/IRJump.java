package IR;

public class IRJump extends IRInstruction {
    public IRLabel dest;

    public IRJump(IRLabel d) {
        dest = d;
        instructionType = IRInstructionType.JUMP;
    }
    public String toString() {
        return String.format("GOTO %s;", dest.labelName());
    }
    public String toStringAssembly() {
        return "";   
    }
}
