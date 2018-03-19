package IR;

public class AssignmentConstant extends IRAssignment {
    String constant;

    public AssignmentConstant(TempVariable t, String c) {
        constant = c;
        destOperand = t;
    }

    public String toString() {
        return String.format("%s := %s;", destOperand, constant);
    }

}

