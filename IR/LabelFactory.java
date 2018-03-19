package IR;
import java.util.List;
import Environment.*;
import Types.*;
import java.io.*;

public class LabelFactory {
    private int entries;
    private String prefix;
    ListEnvironment tempEnvironment;

    public LabelFactory(String pf) {
        tempEnvironment = new ListEnvironment();
        prefix = pf;
        entries = 0;
    }
    public void printTemps(PrintStream out) {
        List<Object> l = tempEnvironment.getList();
        for(Object o : l) {
            TempVariable tv = (TempVariable)o;
            out.println(tv.toStringDec());
        }
    }
    public String get(int num) {
        return "L" + num;
    }
    public String add() {
        int num = entries;
        entries++;
        return "L" + num;
    }
}

