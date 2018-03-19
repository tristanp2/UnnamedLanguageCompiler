package IR;

public class IRReturn extends IRInstruction{
    TempVariable temp;

    public IRReturn(){
        temp = null;
    }
    public IRReturn(TempVariable t){
        temp = t;
    }
    public String toString(){
        String ret = "RETURN";
        if(temp != null){
            return ret + " " + temp + ";";
        }
        else{
            return ret + ";";
        }
    }
}
