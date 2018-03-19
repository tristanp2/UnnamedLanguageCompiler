package IR;

public class IRAssignmentConstant extends IRAssignment {
    String constant;

    public IRAssignmentConstant(TempVariable t, String c) {
        constant = c;
        destOperand = t;
    }

    public String toString() {
        return String.format("%s := %s;", destOperand, constant);
    }

}

