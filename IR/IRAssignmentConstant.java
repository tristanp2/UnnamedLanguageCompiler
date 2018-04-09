package IR;

public class IRAssignmentConstant extends IRAssignment {
    public String constant;

    public IRAssignmentConstant(TempVariable t, String c) {
        constant = c;
        destOperand = t;
        instructionType = IRInstructionType.ASSNCONSTANT;
    }

    public String toString() {
        return String.format("%s := %s;", destOperand, constant);
    }
    public String toStringAssembly() {
        return "";   
    }

}

