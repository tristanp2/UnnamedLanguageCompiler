package IR;
import Types.ArrayType;
import Types.TypeEnum;

public class IRAssignmentArrayInit extends IRAssignment {
    public ArrayType at;

    public IRAssignmentArrayInit(TempVariable dest, ArrayType at){
        this.at = at;
        destOperand = dest;
        instructionType = IRInstructionType.ASSNARRAYINIT;
    }
    public String toString() {
        return String.format("%s := NEWARRAY %s %s;", destOperand, at.elementType.toStringIR(), at.size);
    }
    public String toStringAssembly() {
        String ret;
        String indent = "    ";
        if(at.elementType.equals(TypeEnum.STRING)) {
            ret = String.format("%s%s %s\n%s%s %s\n%s%s %s\n",  indent, "ldc", at.size,
                                                                indent, "anewarray", "java/lang/String",
                                                                indent, "astore", destOperand.num); 
        }
        else {
            ret = String.format("%s%s %s\n%s%s %s\n%s%s %s\n",  indent, "ldc", at.size,
                                                                indent, "newarray", at.elementType,
                                                                indent, "astore", destOperand.num); 
        }
        return ret;
    }
}

