package IR;
import Types.Type;

public class AssignmentNewArray extends IRAssignment {
    Type arrayElementType;
    int arraySize;

    public AssignmentNewArray(TempVariable temp, Type t, int s) {
        destOperand = temp;
        arrayElementType = t;
        arraySize = s;
    }

    public String toString() {
        return String.format("%s := NEWARRAY(%s)%d;", destOperand, arrayElementType.toStringIR(), arraySize);
    }
}
