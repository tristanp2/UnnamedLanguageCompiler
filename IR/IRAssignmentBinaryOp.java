package IR;
import Types.TypeEnum;

public class IRAssignmentBinaryOp extends IRAssignment {
    public TempVariable srcOperand1;
    public TempVariable srcOperand2;
    public String operator;

    public IRAssignmentBinaryOp(TempVariable d, TempVariable op1, String op, TempVariable op2) {
        destOperand = d;
        srcOperand1 = op1;
        srcOperand2 = op2;
        operator = op;
        instructionType = IRInstructionType.ASSNBINARYOP;
    }

    public String toString() {
        return String.format("%s := %s %s %s;", destOperand, srcOperand1, srcOperand1.type.toStringIR() + operator, srcOperand2);
    }
}
