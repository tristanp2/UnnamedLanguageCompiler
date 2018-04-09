package IR;

import java.util.ArrayList;

public class IRProgram {
    public String progName;
    ArrayList<IRFunction> functionList;

    public IRProgram(String pn) {
        progName = pn;
        functionList = new ArrayList<IRFunction>();
    }
    public void addFunction(IRFunction f) {
        functionList.add(f);
    }
    public ArrayList<IRFunction> getFunctions() {
        return functionList;
    }

    public String toString() {
        String ret = "PROG " + progName + "\n";
        for(IRFunction i : functionList) {
            ret += i;
        }
        return ret;
    }
}
