package IR;

public class IRIfJump extends IRInstruction {
    TempVariable operand;
    IRLabel dest;

    public IRIfJump(TempVariable o, IRLabel d) {
        operand = o;
        dest = d;
    }

    public String toString() {
        return String.format("IF %s GOTO %s;", operand, dest.labelName());
    }
    public String toStringAssembly() {
        return "";   
    }
}
