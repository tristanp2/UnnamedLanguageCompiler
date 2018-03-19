package IR;

public class IRJump extends IRInstruction {
    IRLabel dest;

    public IRJump(IRLabel d) {
        dest = d;
    }
    public String toString() {
        return String.format("GOTO %s;", dest.labelName());
    }
}
