package IR;

public class IRAssignmentUnaryOp extends IRAssignment {
    TempVariable srcOperand;
    String operator;


    public IRAssignmentUnaryOp(TempVariable d, String op, TempVariable s) {
        destOperand = d;
        srcOperand = s;
        operator = op;
    }

    public String toString() {
        return String.format("%s := %s %s;", destOperand, srcOperand.type.toStringIR() + operator, srcOperand);
    }
    public String toStringAssembly() {
        return "";   
    }
}
