package IR;
import Types.Type;
import java.util.ArrayList;

public class IRFunction {
    String funcName;
    Type returnType;
    ArrayList<IRInstruction> instructionList;
    String params;

    public IRFunction(String name, Type rt) {
        funcName = name;
        returnType = rt;
        params = "";
    }
    public void addParam(Type t) {
        params += t.toStringIR();
    }
    public String toString() {
        String returnString = String.format("FUNC %s (%s)%s\n{", funcName, params, returnType.toStringIR());

        //TODO: Indent based on type of instruction
        for (IRInstruction iri: instructionList){
            returnString += iri;
        }
        return "";
    }
}

    

