package IR;
import java.util.List;
import java.util.ArrayList;
import Environment.*;
import Types.*;
import java.io.*;

public class TempHandler {
    private int tempNum;
    ListEnvironment tempEnvironment;

    public TempHandler() {
        tempEnvironment = new ListEnvironment();
        tempNum = 0;
    }
    public String toString() {
        List<Object> l = tempEnvironment.getList();
        String returnString = "";
        for(Object o : l) {
            TempVariable tv = (TempVariable)o;
            returnString += tv.toStringDec() + ";\n";
        }
        return returnString;
    }
    public List<String> preambleVarList() {
        List<Object> l = tempEnvironment.getList();
        List<String> sl = new ArrayList<String>();
        for(Object o : l) {
            TempVariable tv = (TempVariable)o;
            sl.add(tv.toStringAssembly());
        }
        return sl;
    }

    public TempVariable get(String key) {
        TempVariable tv = (TempVariable)tempEnvironment.lookup(key);

        return tv;
    }
    //for intermediate values
    public TempVariable addIntermediate(Type t) {
        TempVariable tv = new TempVariable(tempNum, t);
        //should be fine since key is not valid id?
        tempEnvironment.add("*" + Integer.toString(tempNum), tv);
        tempNum++;
        return tv;
    }
    public TempVariable addIntermediate(String key, Type t) {
        TempVariable tv = (TempVariable)tempEnvironment.lookup(key);

        if(tv != null) {
            return tv;
        }

        tv = new TempVariable(tempNum, t);
        tempNum++;
        tempEnvironment.add(key, tv);

        return tv;
    }
        
    public TempVariable addParameter(String key, Type t) {
        TempVariable tv = (TempVariable)tempEnvironment.lookup(key);

        if(tv != null) {
            return tv;
        }

        tv = new TempVariable(tempNum, t, key, TempEnum.PARAMETER);
        tempNum++;
        tempEnvironment.add(key, tv);

        return tv;
    }
    public TempVariable addLocal(String key, Type t) {
        TempVariable tv = (TempVariable)tempEnvironment.lookup(key);

        //maybe should throw error?
        if(tv != null) {
            return tv;
        }
        
        tv = new TempVariable(tempNum, t, key, TempEnum.LOCAL);
        tempNum++;
        tempEnvironment.add(key, tv);
        
        return tv;
    }
}

