package IR;
import Types.Type;


public class TempVariable {
    public Integer num;
    public Type type;
    String paramNote;
    
    public TempVariable(Integer tn, Type tt, String pn){
        num = tn;
        type = tt;
        paramNote = pn;
    }
    public TempVariable(Integer tn, Type tt) {
        this(tn,tt,null);
    }
    public String toString() {
        return "T" + num;
    }
    public String toStringDec() {
        return "TEMP " + num + ":" + type.toStringIR();
    }
}
