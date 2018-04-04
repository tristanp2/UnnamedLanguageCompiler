package IR;
import Types.ArrayType;

public class IRAssignmentArrayInit extends IRAssignment {
    ArrayType at;

    public IRAssignmentArrayInit(TempVariable dest, ArrayType at){
        this.at = at;
        destOperand = dest;
    }
    public String toString() {
        return String.format("%s := NEWARRAY %s %s;", destOperand, at.elementType.toStringIR(), at.size);
    }
}

