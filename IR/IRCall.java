package IR;
import java.util.ArrayList;

public class IRCall extends IRInstruction{
    public String memberName;
    public ArrayList<TempVariable> params;
    public TempVariable destOperand;

    public IRCall(String mn){
        memberName = mn;
        params = new ArrayList<TempVariable>();
        destOperand = null;
        instructionType = IRInstructionType.CALL;
    }
    public void addParam(TempVariable t){
        params.add(t);
    }
    public void setDest(TempVariable t){
        destOperand = t;
    }
    public String toString() {
        if(destOperand == null){
            String ret = "CALL " + memberName + "(";
            for(TempVariable t: params){
                ret += t;
                ret += " ";
            }
            ret += ");";
            return ret;
        }
        else{
            String ret = String.format("%s := CALL %s(", destOperand, memberName);
            for(TempVariable t: params){
                ret += t;
                ret += " ";
            }
            ret += ");";
            return ret;
        }
    }
}
