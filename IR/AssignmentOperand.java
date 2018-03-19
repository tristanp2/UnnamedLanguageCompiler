package IR;

public class AssignmentOperand extends IRAssignment {
    TempVariable srcOperand;
    public AssignmentOperand(TempVariable d, TempVariable s) {
        destOperand = d;
        srcOperand = s;
    }
    public String toString() {
        return String.format("%s := %s;",destOperand, srcOperand);
    }
}
