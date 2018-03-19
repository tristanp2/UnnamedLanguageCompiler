package IR;

public class IRLabel extends IRInstruction{
    Integer labelNum;

    public IRLabel(int ln) {
        labelNum = ln;
    }
    public String labelName() {
        return "L" + labelNum;
    }
    public String toString() {
        return labelName() + ";"; 
    }
}
