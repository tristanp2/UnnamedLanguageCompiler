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
        tempH = new TempHandler();
    }
    public void addParam(Type t) {
        params += t.toStringIR();
    }
    public void addInstruction(IRInstruction i) {
        instructionList.add(i);
    }
    public TempVariable addLiteral(String value, Type t) {
        String litName = literalName(value,t);
        System.out.println(litName);
        return tempH.add(litName, t);
    }
    public TempVariable lookupLiteral(String value, Type t) {
        String litName = literalName(value,t);
        return tempH.get(litName);
    }
    public TempVariable addTemp(String name, Type t) {
        return tempH.add(name, t);
    }
    //for intermed values
    public TempVariable addTemp(Type t) {
        return tempH.add(t);
    }
    public TempVariable lookupTemp(String name) {
        return tempH.get(name);
    }
    //key for literal values
    //not a valid id, so shouldn't conflict
    private String literalName(String value, Type t){
        return "*" + t + value;
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

    

