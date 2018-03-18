package IR;
import java.util.List;
import Environment.*;
import Types.*;
import java.io.*;

public class TempFactory {
    private class TempInfo {
        public TempInfo(Integer tn, Type tt) {
            tempNum = tn;
            tempType = tt;
        }
        public Integer tempNum;
        public Type tempType;
        public String toString() {
            return "T" + tempNum;
        }
        public String toStringDec() {
            return "TEMP " + tempNum + ":" + tempType.toStringIR();
        }
    }
    private int tempNum;
    ListEnvironment tempEnvironment;

    public TempFactory() {
        tempEnvironment = new ListEnvironment();
        tempNum = 0;
    }
    public void printTemps(PrintStream out) {
        List<Object> l = tempEnvironment.getList();
        for(Object o : l) {
            TempInfo ti = (TempInfo)o;
            out.println(ti.toStringDec());
        }
    }
    public String get(String key) {
        TempInfo ti = (TempInfo)tempEnvironment.lookup(key);

        if(ti == null)
            return null;

        return ti.toString();
    }
    public String add(String key, Type t) {
        TempInfo ti = (TempInfo)tempEnvironment.lookup(key);

        //maybe should throw error?
        if(ti != null) {
            return ti.toString();
        }
        
        ti = new TempInfo(tempNum, t);
        tempNum++;
        tempEnvironment.add(key, ti);
        
        return ti.toString();
    }
}

