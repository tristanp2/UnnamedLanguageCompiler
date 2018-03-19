package IR;
import Types.Type;


public class TempVariable {
    public TempVariable(Integer tn, Type tt) {
        num = tn;
        type = tt;
    }
    public Integer num;
    public Type type;
    public String toString() {
        return "T" + num;
    }
    public String toStringDec() {
        return "TEMP " + num + ":" + type.toStringIR();
    }
}
