package IR;
import java.util.ArrayList;

public class IRCall extends IRInstruction{
    String memberName;
    ArrayList<TempVariable> params;
    TempVariable dest;

    public IRCall(String mn){
        memberName = mn;
        params = new ArrayList<TempVariable>();
        dest = null;
    }
    public void addParam(TempVariable t){
        params.add(t);
    }
    public void setDest(TempVariable t){
        dest = t;
    }
    public String toString() {
        if(dest == null){
            String ret = "CALL " + memberName + "(";
            for(TempVariable t: params){
                ret += t;
                ret += " ";
            }
            ret += ");";
            return ret;
        }
        else{
            String ret = String.format("%s := CALL %s(", dest, memberName);
            for(TempVariable t: params){
                ret += t;
                ret += " ";
            }
            ret += ");";
            return ret;
        }
    }
    public String toStringAssembly() {
        return "";   
    }
}
