package IR;
import Types.Type;


public class TempVariable {
    public Integer num;
    public Type type;
    String name;
    TempEnum tempType;
    
    public TempVariable(Integer tn, Type tt, String pn, TempEnum te){
        num = tn;
        type = tt;
        name = pn;
        tempType = te;
    }
    public TempVariable(Integer tn, Type tt) {
        this(tn,tt,null, TempEnum.INTERMEDIATE);
    }
    public String toString() {
        return "T" + num;
    }
    public String toStringDec() {
        String declaration = "TEMP " + num + ":" + type.toStringIR();
        String annot = "";

        if(tempType == TempEnum.LOCAL) {
            annot = String.format(" [L(\"%s\")]",name);
        }
        else if(tempType == TempEnum.PARAMETER) {
            annot = String.format(" [P(\"%s\")]", name);
        }

        return declaration + annot;
    }
}
