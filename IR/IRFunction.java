package IR;
import Types.Type;
import Types.TypeEnum;
import java.util.ArrayList;
import java.util.List;

public class IRFunction {
    public String funcName;
    public Type returnType;
    private final String jlString = "Ljava/lang/String;";
    TempHandler tempH;
    ArrayList<IRInstruction> instructionList;
    ArrayList<Type> params;

    public IRFunction() {
        params = new ArrayList<Type>();
        instructionList = new ArrayList<IRInstruction>();
        tempH = new TempHandler();
    }
    public void addParam(Type t) {
        params.add(t);
    }
    public void addInstruction(IRInstruction i) {
        instructionList.add(i);
    }
    public TempVariable addParameter(String name, Type t) {
        return tempH.addParameter(name, t);
    }
    public TempVariable addLocal(String name, Type t) {
        return tempH.addLocal(name, t);
    }
    //for intermed values
    public TempVariable addIntermediate(Type t) {
        return tempH.addIntermediate(t);
    }
    public TempVariable lookupTemp(String name) {
        return tempH.get(name);
    }
    public ArrayList<IRInstruction> getInstructions(){
        return instructionList;
    }
        
    public String toString() {
        String returnString = String.format("FUNC %s\n{\n", irSignature());
        returnString += tempH.toString();

        //TODO: Indent based on type of instruction
        for (IRInstruction iri: instructionList){
            returnString += iri + "\n";
        }
        returnString += "}\n";
        return returnString;
    }
    public String irSignature() {
        String paramString = "";
        for(Type t : params) {
            paramString += t.toStringIR();
        }
        return String.format("%s (%s)%s", funcName, paramString, returnType.toStringIR());
    }
    public String assemblySignature(){
        String paramString = "";
        String returnString;
        for(Type t : params) {
            if(t.equals(TypeEnum.STRING)){
                paramString += jlString;
            }
            else{
                paramString += t.toStringIR();
            }
        }

        if(returnType.equals(TypeEnum.STRING)){
            returnString = jlString;
        }
        else{
            returnString = returnType.toStringIR();
        }
        return String.format("%s(%s)%s", funcName, paramString, returnString);
    }
    public List<String> assemblyPreamble() {
        return tempH.preambleVarList();
    }


}

    

