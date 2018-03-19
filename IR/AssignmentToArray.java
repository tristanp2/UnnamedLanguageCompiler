package IR;

public class AssignmentToArray extends IRAssignment {
    TempVariable destIndex;
    TempVariable srcOperand;

    public AssignmentToArray(TempVariable dest, TempVariable di, TempVariable so) {
        destOperand = dest;
        destIndex = di;
        srcOperand = so;
    }
    public String toString() {
        return String.format("%s[%s] := %s;",destOperand, destIndex, srcOperand);
    }
}
