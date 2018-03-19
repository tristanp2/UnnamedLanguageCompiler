package IR;
import java.util.List;
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
    public String tempDeclarationsToString() {
        List<Object> l = tempEnvironment.getList();
        String returnString = "";
        for(Object o : l) {
            TempVariable tv = (TempVariable)o;
            returnString += tv.toStringDec() + "\n";
        }
        return returnString;
    }
    public String get(String key) {
        TempVariable tv = (TempVariable)tempEnvironment.lookup(key);

        if(tv == null)
            return null;

        return tv.toString();
    }
    public String add(String key, Type t) {
        TempVariable tv = (TempVariable)tempEnvironment.lookup(key);

        //maybe should throw error?
        if(tv != null) {
            return tv.toString();
        }
        
        tv = new TempVariable(tempNum, t);
        tempNum++;
        tempEnvironment.add(key, tv);
        
        return tv.toString();
    }
}

