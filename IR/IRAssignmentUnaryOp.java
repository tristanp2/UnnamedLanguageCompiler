package IR;

public class IRAssignmentUnaryOp extends IRAssignment {
    public TempVariable srcOperand;
    public String operator;


    public IRAssignmentUnaryOp(TempVariable d, String op, TempVariable s) {
        destOperand = d;
        srcOperand = s;
        operator = op;
        instructionType = IRInstructionType.ASSNUNARYOP;
    }

    public String toString() {
        return String.format("%s := %s %s;", destOperand, srcOperand.type.toStringIR() + operator, srcOperand);
    }
    public String toStringAssembly() {
        return "";   
    }
}
