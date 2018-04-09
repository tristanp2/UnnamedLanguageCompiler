package IR;

public class IRAssignmentFromArray extends IRAssignment {
    public TempVariable srcOperand;
    public TempVariable srcIndex;

    public IRAssignmentFromArray(TempVariable dest, TempVariable so, TempVariable si) {
        destOperand = dest;
        srcOperand = so;
        srcIndex = si;
        instructionType = IRInstructionType.ASSNFROMARRAY;
    }
    public String toString() {
        return String.format("%s := %s[%s];", destOperand, srcOperand, srcIndex);
    }
    public String toStringAssembly() {
        return "";   
    }
}
