package IR;

public class IRAssignmentOperand extends IRAssignment {
    TempVariable srcOperand;
    public IRAssignmentOperand(TempVariable d, TempVariable s) {
        destOperand = d;
        srcOperand = s;
    }
    public String toString() {
        return String.format("%s := %s;",destOperand, srcOperand);
    }
    public String toStringAssembly() {
        return "";   
    }
}
