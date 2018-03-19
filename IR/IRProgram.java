package IR;

import java.util.ArrayList;

public class IRProgram {
    ArrayList<IRFunction> functionList;

    public IRProgram() {
        functionList = new ArrayList<IRFunction>();
    }
    public void addFunction(IRFunction f) {
        functionList.add(f);
    }
}
