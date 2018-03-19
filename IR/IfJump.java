package IR;

public class IfJump extends IRInstruction {
    TempVariable operand;
    Label dest;

    public IfJump(TempVariable o, Label d) {
        operand = o;
        dest = d;
    }

    public String toString() {
        return String.format("IF %s GOTO %s;", operand, dest);
    }
}
