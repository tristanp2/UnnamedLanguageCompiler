package IR;

public class Jump extends IRInstruction {
    Label dest;

    public Jump(Label d) {
        dest = d;
    }
    public String toString() {
        return String.format("GOTO %s;", dest);
    }
}
