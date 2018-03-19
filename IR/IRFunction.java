package IR;
import Types.Type;
import java.util.ArrayList;

public class IRFunction {
    public String funcName;
    public Type returnType;
    TempHandler tempH;
    ArrayList<IRInstruction> instructionList;
    String params;

    public IRFunction() {
        params = "";
        instructionList = new ArrayList<IRInstruction>();
    }
    public void addParam(Type t) {
        params += t.toStringIR();
    }
    public TempVariable addTemp(String name, Type t) {
        return tempH.add(name, t);
    }
    public TempVariable lookupTemp(String name) {
        return tempH.get(name);
    }

    public String toString() {
        String returnString = String.format("FUNC %s (%s)%s\n{\n", funcName, params, returnType.toStringIR());
        returnString += tempH.toString();

        //TODO: Indent based on type of instruction
        for (IRInstruction iri: instructionList){
            returnString += iri + "\n";
        }
        returnString += "}\n";
        return returnString;
    }
}

    

