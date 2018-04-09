package IR;

public class IRReturn extends IRInstruction{
    public TempVariable operand;

    public IRReturn(){
        operand = null;
        instructionType = IRInstructionType.RETURN;
    }
    public IRReturn(TempVariable t){
        operand = t;
        instructionType = IRInstructionType.RETURN;
    }
    public String toString(){
        String ret = "RETURN";
        if(operand != null){
            return ret + " " + operand + ";";
        }
        else{
            return ret + ";";
        }
    }
    public String toStringAssembly() {
        return "";   
    }
}
