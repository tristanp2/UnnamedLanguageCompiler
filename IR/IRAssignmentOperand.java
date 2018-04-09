package IR;

public class IRAssignmentOperand extends IRAssignment {
    public TempVariable srcOperand;
    public IRAssignmentOperand(TempVariable d, TempVariable s) {
        destOperand = d;
        srcOperand = s;
        instructionType = IRInstructionType.ASSNOPERAND;
    }
    public String toString() {
        return String.format("%s := %s;",destOperand, srcOperand);
    }
    public String toStringAssembly() {
        return "";   
    }
}
