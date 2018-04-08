package IR;

public class IRAssignmentToArray extends IRAssignment {
    TempVariable destIndex;
    TempVariable srcOperand;

    public IRAssignmentToArray(TempVariable dest, TempVariable di, TempVariable so) {
        destOperand = dest;
        destIndex = di;
        srcOperand = so;
    }
    public String toString() {
        return String.format("%s[%s] := %s;",destOperand, destIndex, srcOperand);
    }
    public String toStringAssembly() {
        return "";   
    }
}
