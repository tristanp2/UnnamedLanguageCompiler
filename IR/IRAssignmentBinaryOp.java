package IR;

public class IRAssignmentBinaryOp extends IRAssignment {
    TempVariable srcOperand1;
    TempVariable srcOperand2;
    String operator;

    public IRAssignmentBinaryOp(TempVariable d, TempVariable op1, String op, TempVariable op2) {
        destOperand = d;
        srcOperand1 = op1;
        srcOperand2 = op2;
        operator = op;
    }

    public String toString() {
        return String.format("%s := %s %s %s;", destOperand, srcOperand1, srcOperand1.type.toStringIR() + operator, srcOperand2);
    }
}
