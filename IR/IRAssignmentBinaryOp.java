package IR;
import Types.TypeEnum;

public class IRAssignmentBinaryOp extends IRAssignment {
    TempVariable srcOperand1;
    TempVariable srcOperand2;
    String operator;

    public IRAssignmentBinaryOp(TempVariable d, TempVariable op1, String op, TempVariable op2) {
        destOperand = d;
        srcOperand1 = op1;
        srcOperand2 = op2;
        operator = op;
    }

    public String toString() {
        return String.format("%s := %s %s %s;", destOperand, srcOperand1, srcOperand1.type.toStringIR() + operator, srcOperand2);
    }
    public String toStringAssembly() {
        String ret = "";
        String indent = "    ";
        switch(operator){
            case "+":
                switch(srcOperand1.type.typeEnum){
                    case INTEGER:
                        ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s %s\n",    
                                                indent, "iload", srcOperand1.num,
                                                indent, "iload", srcOperand2.num,
                                                indent, "iadd",
                                                indent, "istore", destOperand.num
                                           );     
                        break;
                    case FLOAT:
                        ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s %s\n",    
                                                indent, "fload", srcOperand1.num,
                                                indent, "fload", srcOperand2.num,
                                                indent, "fadd",
                                                indent, "fstore", destOperand.num
                                           );     
                        break;
                    case CHAR:
                        ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s\n%s%s %s\n",    
                                                indent, "iload", srcOperand1.num,
                                                indent, "iload", srcOperand2.num,
                                                indent, "iadd",
                                                indent, "i2c",
                                                indent, "istore", destOperand.num
                                           );     
                        break;
                    case STRING:
                        ret = String.format("%s%s %s\n%s%s\n%s%s %s\n%s%s %s\n%s%s %s\n%s%s %s\n%s%s %s\n%s%s %s\n%s%s %s\n",
                                                indent, "new", "java/lang/StringBuffer",
                                                indent, "dup",
                                                indent, "invokenonvirtual", "java/lang/StringBuffer/<init>()V",
                                                indent, "aload", srcOperand1.num,
                                                indent, "invokevirtual", "java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;",
                                                indent, "aload", srcOperand2.num,
                                                indent, "invokevirtual", "java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;",
                                                indent, "invokevirtual", "java/lang/StringBuffer/toString()Ljava/lang/String;",
                                                indent, "astore", destOperand.num
                                            );
                        break;
                }
                break;
            case "-":
                switch(srcOperand1.type.typeEnum){
                    case INTEGER:
                            ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s %s\n",    
                                                    indent, "iload", srcOperand1.num,
                                                    indent, "iload", srcOperand2.num,
                                                    indent, "isub",
                                                    indent, "istore", destOperand.num
                                               );     
                        case FLOAT:
                            ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s %s\n",    
                                                    indent, "fload", srcOperand1.num,
                                                    indent, "fload", srcOperand2.num,
                                                    indent, "fsub",
                                                    indent, "fstore", destOperand.num
                                               );     
                            break;
                    case CHAR:
                        ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s\n%s%s %s\n",    
                                                indent, "iload", srcOperand1.num,
                                                indent, "iload", srcOperand2.num,
                                                indent, "isub",
                                                indent, "i2c",
                                                indent, "istore", destOperand.num
                                           );     
                        break;
                }
                break;
            case "*":
                switch(srcOperand1.type.typeEnum){
                    case INTEGER:  
                        ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s %s\n",    
                                                indent, "iload", srcOperand1.num,
                                                indent, "iload", srcOperand2.num,
                                                indent, "imul",
                                                indent, "istore", destOperand.num
                                           );     
                        break;
                    case FLOAT:
                        ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s %s\n",    
                                                indent, "fload", srcOperand1.num,
                                                indent, "fload", srcOperand2.num,
                                                indent, "fmul",
                                                indent, "fstore", destOperand.num
                                           );     
                        break;
                }
                break;
            case "<":
                switch(srcOperand1.type.typeEnum){
                    case INTEGER:  
                        ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s %s\n",    
                                                indent, "iload", srcOperand1.num,
                                                indent, "iload", srcOperand2.num,
                                                indent, "isub",
                                                iflt
                                                indent, "istore", destOperand.num
                                           );     
                        break;
                    case FLOAT:
                        ret = String.format("%s%s %s\n%s%s %s\n%s%s\n%s%s %s\n",    
                                                indent, "fload", srcOperand1.num,
                                                indent, "fload", srcOperand2.num,
                                                indent, "fmul",
                                                indent, "fstore", destOperand.num
                                           );     
                        break;
                        
        }
            
        return "";
    }
}
