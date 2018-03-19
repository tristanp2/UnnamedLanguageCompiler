package IR;

public class AssignmentFromArray extends IRAssignment {
    TempVariable srcOperand;
    TempVariable srcIndex;

    public AssignmentFromArray(TempVariable dest, TempVariable so, TempVariable si) {
        destOperand = dest;
        srcOperand = so;
        srcIndex = si;
    }
    public String toString() {
        return String.format("%s := %s[%s];", destOperand, srcOperand, srcIndex);
    }
}
