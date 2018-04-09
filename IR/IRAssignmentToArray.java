package IR;

public class IRAssignmentToArray extends IRAssignment {
    public TempVariable destIndex;
    public TempVariable srcOperand;

    public IRAssignmentToArray(TempVariable dest, TempVariable di, TempVariable so) {
        destOperand = dest;
        destIndex = di;
        srcOperand = so;
        instructionType = IRInstructionType.ASSNTOARRAY;
    }
    public String toString() {
        return String.format("%s[%s] := %s;",destOperand, destIndex, srcOperand);
    }
    public String toStringAssembly() {
        return "";   
    }
}
