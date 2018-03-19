package IR;

public class IRAssignmentFromArray extends IRAssignment {
    TempVariable srcOperand;
    TempVariable srcIndex;

    public IRAssignmentFromArray(TempVariable dest, TempVariable so, TempVariable si) {
        destOperand = dest;
        srcOperand = so;
        srcIndex = si;
    }
    public String toString() {
        return String.format("%s := %s[%s];", destOperand, srcOperand, srcIndex);
    }
}
