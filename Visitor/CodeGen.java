package Visitor;
import IR.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import Types.TypeEnum;
import Environment.ListEnvironment;

public class CodeGen {
    IRProgram p;
    PrintStream out;
    Integer numLabels;
    ListEnvironment funcEnv;

    static final String indent = "    ";
    public CodeGen(IRProgram irp, OutputStream os) {
        funcEnv = new ListEnvironment();
        out = new PrintStream(os);
        p = irp;
        numLabels = 0;
        for(IRFunction f : p.getFunctions()) {
            funcEnv.add(f.funcName, f);
        }
    }
    public void generateAssembly() {
        out.printf(".source %s.ir\n", p.progName);
        out.printf(".class public %s\n", p.progName);
        out.println(".super java/lang/Object");
        out.println();
        for(IRFunction f : p.getFunctions()) {
            int label1 = numLabels++;
            int label2 = numLabels++;
            if(f.funcName.equals("main")){
                out.println(".method public static __main()V");
            }
            else{
                out.printf(".method public static %s\n",f.assemblySignature());
            }
            List<String> sl = f.assemblyPreamble();
            out.printf("%s.limit locals %d\n",indent, sl.size()); 
            for(String s : sl) {
                out.printf("%s%s from L_%d to L_%d\n",indent, s, label1, label2);
            }
            out.printf("%s.limit stack %d\n",indent, sl.size()*4);
            out.printf("L_%d:\n",label1);
            List<TempVariable> tl = f.localList();
            for(TempVariable tv : tl) {
                switch(tv.type.typeEnum) {
                    case INTEGER:
                    case CHAR:
                    case BOOLEAN:
                        out.printf("%sldc 0\n", indent);
                        out.printf("%sistore %d\n",indent, tv.num);
                        break;
                    case STRING:
                    case ARRAY:
                        out.printf("%saconst_null\n",indent);
                        out.printf("%sastore %d\n",indent, tv.num);
                        break;
                }
            }
            for(IRInstruction i : f.getInstructions()) {
                //System.out.println(i);
                switch(i.instructionType) {
                    case ASSNARRAYINIT:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRAssignmentArrayInit)i);
                        break;
                    case ASSNBINARYOP:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRAssignmentBinaryOp)i);
                        break;
                    case ASSNCONSTANT:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRAssignmentConstant)i);
                        break;
                    case ASSNFROMARRAY:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRAssignmentFromArray)i);
                        break;
                    case ASSNOPERAND:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRAssignmentOperand)i);
                        break;
                    case ASSNTOARRAY:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRAssignmentToArray)i);
                        break;
                    case ASSNUNARYOP:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRAssignmentUnaryOp)i);
                        break;
                    case CALL:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRCall)i);
                        break;
                    case IFJUMP:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRIfJump)i);
                        break;
                    case JUMP:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRJump)i);
                        break;
                    case LABEL:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRLabel)i);
                        break;
                    case PRINT:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRPrint)i);
                        break;
                    case PRINTLN:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRPrintLn)i);
                        break;
                    case RETURN:
                        out.printf(";%s%s %s\n",indent,indent, i.toString()); 
                        translate((IRReturn)i);
                        break;
                }
            }
            out.printf("L_%d:\n",label2);
            out.println(".end method");
        }
        out.println();
        out.println(";---------------------------;");
        out.println(";  Boiler's plates          ;");
        out.println(";---------------------------;");
        out.println();
        
        out.println(".method public static main([Ljava/lang/String;)V\n");
        out.printf("%s.limit locals 1\n",indent);
        out.printf("%s.limit stack 4\n",indent);
        out.printf("%sinvokestatic %s/__main()V\n",indent, p.progName);
        out.printf("%sreturn\n", indent);
        out.println(".end method");
        out.println();

        out.println(".method public <init>()V");
        out.printf("%saload_0\n",indent);
        out.printf("%sinvokenonvirtual java/lang/Object/<init>()V\n",indent);
        out.printf("%sreturn\n",indent);
        out.println(".end method");

    }
    void translate(IRAssignmentArrayInit i) {
        if(i.at.elementType.equals(TypeEnum.STRING)) {
            out.printf("%sldc %d\n",indent, i.at.size);
            out.printf("%sanewarray java/lang/String\n",indent);
            out.printf("%sastore %d\n",indent, i.destOperand.num);
        }
        else {
            out.printf("%sldc %d\n",indent, i.at.size);
            out.printf("%snewarray %s\n",indent, i.at.elementType);
            out.printf("%sastore %d\n",indent, i.destOperand.num);
        }
    }
    void translate(IRAssignmentBinaryOp i) {
        switch(i.operator) {
            case "+":
                switch(i.srcOperand1.type.typeEnum){
                    case INTEGER:
                        out.printf("%siload %d\n",indent, i.srcOperand1.num);
                        out.printf("%siload %d\n",indent, i.srcOperand2.num);
                        out.printf("%siadd\n",indent);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case FLOAT:
                        out.printf("%sfload %d\n",indent, i.srcOperand1.num);
                        out.printf("%sfload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sfadd\n",indent);
                        out.printf("%sfstore %d\n",indent, i.destOperand.num);
                        break;
                    case CHAR:
                        out.printf("%siload %d\n",indent, i.srcOperand1.num);
                        out.printf("%siload %d\n",indent, i.srcOperand2.num);
                        out.printf("%siadd\n",indent);
                        out.printf("%si2c\n",indent);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case STRING:
                        out.printf("%snew java/land/StringBuffer\n",indent);
                        out.printf("%sdup\n",indent);
                        out.printf("%sinvokenonvirtual java/lang/StringBuffer/<init>()V\n",indent);
                        out.printf("%saload %d\n",indent, i.srcOperand1.num);
                        out.printf("%sinvokevirtual java/lang/StringBuffer/append(L/java/land/String;)Ljava/land/StringBugger;\n",
                                    indent);
                        out.printf("%saload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sinvokevirtual java/lang/StringBuffer/append(L/java/land/String;)Ljava/land/StringBugger;\n",
                                    indent);
                        out.printf("%sastore %d",indent, i.destOperand.num);
                    break; 
                }
                break;
            case "-":
                switch(i.srcOperand1.type.typeEnum) {
                    case INTEGER:
                        out.printf("%siload %d\n",indent, i.srcOperand1.num);
                        out.printf("%siload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sisub\n",indent);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case FLOAT:
                        out.printf("%sfload %d\n",indent, i.srcOperand1.num);
                        out.printf("%sfload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sfsub\n",indent);
                        out.printf("%sfstore %d\n",indent, i.destOperand.num);
                        break;
                    case CHAR:
                        out.printf("%siload %d\n",indent, i.srcOperand1.num);
                        out.printf("%siload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sisub\n",indent);
                        out.printf("%si2c\n",indent);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                }
                break;
            case "*":
                switch(i.srcOperand1.type.typeEnum) {
                    case INTEGER:
                        out.printf("%siload %d\n",indent, i.srcOperand1.num);
                        out.printf("%siload %d\n",indent, i.srcOperand2.num);
                        out.printf("%simul\n",indent);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case FLOAT:
                        out.printf("%sfload %d\n",indent, i.srcOperand1.num);
                        out.printf("%sfload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sfmul\n",indent);
                        out.printf("%sfstore %d\n",indent, i.destOperand.num);
                        break;
                }
                break;
            case "<":{
                int label1, label2;
                switch(i.srcOperand1.type.typeEnum) {
                    case INTEGER:
                    case CHAR:
                        out.printf("%siload %d\n",indent, i.srcOperand1.num);
                        out.printf("%siload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sisub\n",indent);
                        label1 = numLabels++;
                        out.printf("%siflt L_%d\n",indent, label1);
                        out.printf("%sldc 0\n",indent);
                        label2 = numLabels++;
                        out.printf("%sgoto L_%d\n",indent, label2);
                        out.printf("L_%d:\n",label1);
                        out.printf("%sldc 1\n",indent);
                        out.printf("L_%d:\n", label2);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case FLOAT:
                        out.printf("%sfload %d\n",indent, i.srcOperand1.num);
                        out.printf("%sfload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sfcmpg\n",indent);
                        label1 = numLabels++;
                        out.printf("%siflt L_%d\n",indent, label1);
                        out.printf("%sldc 0\n",indent);
                        label2 = numLabels++;
                        out.printf("%sgoto L_%d\n",indent, label2);
                        out.printf("L_%d:\n",label1);
                        out.printf("%sldc 1\n",indent);
                        out.printf("L_%d:\n", label2);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case STRING:
                        out.printf("%saload %d\n",indent, i.srcOperand1.num);
                        out.printf("%saload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sinvokevirtual java/lang/String/compareTo(Ljava/lang/String;)I\n",indent);
                        label1 = numLabels++;
                        out.printf("%siflt L_%d\n",indent, label1);
                        out.printf("%sldc 0\n",indent);
                        label2 = numLabels++;
                        out.printf("%sgoto L_%d\n",indent, label2);
                        out.printf("L_%d:\n",label1);
                        out.printf("%sldc 1\n",indent);
                        out.printf("L_%d:\n", label2);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                }
                break;
            }
            case "==":{
                int label1, label2;
                switch(i.srcOperand1.type.typeEnum) {
                    case INTEGER:
                    case CHAR:
                        out.printf("%siload %d\n",indent, i.srcOperand1.num);
                        out.printf("%siload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sisub\n",indent);
                        label1 = numLabels++;
                        out.printf("%sifeq L_%d\n",indent, label1);
                        out.printf("%sldc 0\n",indent);
                        label2 = numLabels++;
                        out.printf("%sgoto L_%d\n",indent, label2);
                        out.printf("L_%d:\n",label1);
                        out.printf("%sldc 1\n",indent);
                        out.printf("L_%d:\n", label2);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case FLOAT:
                        out.printf("%sfload %d\n",indent, i.srcOperand1.num);
                        out.printf("%sfload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sfcmpg\n",indent);
                        label1 = numLabels++;
                        out.printf("%sifeq L_%d\n",indent, label1);
                        out.printf("%sldc 0\n",indent);
                        label2 = numLabels++;
                        out.printf("%sgoto L_%d\n",indent, label2);
                        out.printf("L_%d:\n",label1);
                        out.printf("%sldc 1\n",indent);
                        out.printf("L_%d:\n", label2);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case STRING:
                        out.printf("%saload %d\n",indent, i.srcOperand1.num);
                        out.printf("%saload %d\n",indent, i.srcOperand2.num);
                        out.printf("%sinvokevirtual java/lang/String/compareTo(Ljava/lang/String;)I\n",indent);
                        label1 = numLabels++;
                        out.printf("%sifeq L_%d\n",indent, label1);
                        out.printf("%sldc 0\n",indent);
                        label2 = numLabels++;
                        out.printf("%sgoto L_%d\n",indent, label2);
                        out.printf("L_%d:\n",label1);
                        out.printf("%sldc 1\n",indent);
                        out.printf("L_%d:\n", label2);
                        out.printf("%sistore %d\n",indent, i.destOperand.num);
                        break;
                    case BOOLEAN:
                        out.printf("%siload %\n",indent, i.srcOperand1.num);
                        out.printf("%siload %\n",indent, i.srcOperand2.num);
                        out.printf("%sixor\n",indent);
                        out.printf("%sldc 1\n",indent);
                        out.printf("%sixor\n");
                        out.printf("%sistore %d\n", i.destOperand.num);
                        break;
                }
                break;
            }
        }
                        
    }
    void translate(IRAssignmentConstant i) {
        switch(i.destOperand.type.typeEnum) {
            case INTEGER:
                out.printf("%sldc %s\n",indent, i.constant);
                out.printf("%sistore %d\n",indent,i.destOperand.num);
                break;
            case CHAR:{
                int value = (int)i.constant.charAt(1); 
                out.printf("%sldc %d\n",indent, value);
                out.printf("%sistore %d\n",indent,i.destOperand.num);
                break;
            }
            case FLOAT:
                out.printf("%sldc %s\n",indent, i.constant);
                out.printf("%sfstore %s\n",indent, i.destOperand.num);
                break;
            case STRING:
                out.printf("%sldc %s\n",indent,i.constant);
                out.printf("%sastore %d\n",indent, i.destOperand.num);
                break;
            case BOOLEAN:{
                int value = 0;
                if(i.constant.equals("TRUE"))
                    value = 1;
                
                out.printf("%sldc %d\n",indent, value);
                out.printf("%sistore %d\n",indent, i.destOperand.num);
            }
        }
    }
    void translate(IRAssignmentFromArray i) {
        out.printf("%saload %d\n",indent, i.srcOperand.num);
        out.printf("%siload %d\n",indent, i.srcIndex.num);
        switch(i.destOperand.type.typeEnum) {
            case INTEGER:
                out.printf("%siaload\n",indent);
                out.printf("%sistore %d\n",indent, i.destOperand.num);
                break;
            case CHAR:
                out.printf("%scaload\n",indent);
                out.printf("%sistore %d\n",indent, i.destOperand.num);
                break;
            case FLOAT:
                out.printf("%sfaload\n",indent);
                out.printf("%sfstore %d\n",indent, i.destOperand.num);
                break;
            case BOOLEAN:
                out.printf("%sbaload\n",indent);
                out.printf("%sistore %d\n",indent, i.destOperand.num);
                break;
            case STRING:
                out.printf("%saaload\n",indent);
                out.printf("%sastore %s\n",indent, i.destOperand.num);
                break;
        }
    }
    void translate(IRAssignmentOperand i) {
        switch(i.destOperand.type.typeEnum){
            case INTEGER:
            case CHAR:
            case BOOLEAN:
                out.printf("%siload %d\n",indent, i.srcOperand.num);
                out.printf("%sistore %d\n",indent, i.destOperand.num);
                break;
            case FLOAT:
                out.printf("%sfload %d\n",indent, i.srcOperand.num);
                out.printf("%sfstore %d\n",indent, i.destOperand.num);
                break;
            case STRING:
                out.printf("%saload %d\n",indent, i.srcOperand.num);
                out.printf("%sastore %d\n",indent, i.destOperand.num);
                break;
        }
    }
    void translate(IRAssignmentToArray i) {
        out.printf("%saload %d\n",indent, i.destOperand.num);
        out.printf("%siload %d\n",indent, i.destIndex.num);
        switch(i.srcOperand.type.typeEnum) {
            case INTEGER:
                out.printf("%siload %d\n",indent, i.srcOperand.num);
                out.printf("%siastore\n",indent);
                break;
            case CHAR:
                out.printf("%siload %d\n", indent, i.srcOperand.num);
                out.printf("%scastore\n",indent);
                break;
            case FLOAT:
                out.printf("%sfload %d\n", indent, i.srcOperand.num);
                out.printf("%sfastore\n",indent);
                break;
            case BOOLEAN:
                out.printf("%siload %d\n",indent, i.srcOperand.num);
                out.printf("%sbastore\n",indent);
                break;
            case STRING:
                out.printf("%saload %d\n", indent, i.srcOperand.num);
                out.printf("%saastore\n",indent);
                break;
        }
    }
    void translate(IRAssignmentUnaryOp i) {
        switch(i.operator) {
            case "!":
                out.printf("%siload %d\n",indent, i.srcOperand.num);
                out.printf("%sldc 1\n",indent);
                out.printf("%sixor\n",indent);
                out.printf("%sistore %d\n",indent, i.destOperand.num);
                break;
        }
    }
    void translate(IRCall i) {
        for(TempVariable tv : i.params) {
            String op = "";
            switch(tv.type.typeEnum) {
                case INTEGER:
                case CHAR:
                case BOOLEAN:
                    op = "i";
                    break;
                case FLOAT:
                    op = "f";
                    break;
                case STRING:
                    op = "a";
                    break;
            }
            out.printf("%s%sload %d\n",indent, op, tv.num);
        }
        IRFunction f = (IRFunction)funcEnv.lookup(i.memberName);
        out.printf("%sinvokestatic %s/%s\n",indent, p.progName, f.assemblySignature());
        
        switch(f.returnType.typeEnum){
            case INTEGER:
            case CHAR:
            case BOOLEAN:
                out.printf("%sistore %d\n",indent, i.destOperand.num);
                break;
            case FLOAT:
                out.printf("%sfstore %d\n",indent, i.destOperand.num);
                break;
            case STRING:
                out.printf("%sastore %d\n",indent, i.destOperand.num);
                break;
        }
                
    }
    void translate(IRIfJump i) {
        out.printf("%siload %d\n",indent, i.operand.num);
        out.printf("%sifne %s\n",indent, i.dest.labelName());
    }
    void translate(IRJump i) {
        out.printf("%sgoto %s\n",indent, i.dest.labelName());
    }
    void translate(IRLabel i) {
        out.printf("%s:\n", i.labelName());
    }
    void translate(IRPrint i) {
        out.printf("%sgetstatic java/lang/System/out Ljava/io/PrintStream;\n",indent);
        switch(i.operand.type.typeEnum) {
            case INTEGER:
            case CHAR:
            case BOOLEAN:
                out.printf("%siload %d\n",indent, i.operand.num);
                break;
            case FLOAT:
                out.printf("%sfload %d\n",indent, i.operand.num);
                break;
            case STRING:
                out.printf("%saload %d\n",indent, i.operand.num);
                out.printf("%sinvokevirtual java/io/PrintStream/print(%s)V\n",indent, "Ljava/lang/String;"); 
                return;
        }
        out.printf("%sinvokevirtual java/io/PrintStream/print(%s)V\n",indent, i.operand.type.toStringIR());        
    }
    void translate(IRPrintLn i) {
        out.printf("%sgetstatic java/lang/System/out Ljava/io/PrintStream;\n",indent);
        switch(i.operand.type.typeEnum) {
            case INTEGER:
            case CHAR:
            case BOOLEAN:
                out.printf("%siload %d\n",indent, i.operand.num);
                break;
            case FLOAT:
                out.printf("%sfload %d\n",indent, i.operand.num);
                break;
            case STRING:
                out.printf("%saload %d\n",indent, i.operand.num);
                out.printf("%sinvokevirtual java/io/PrintStream/println(%s)V\n",indent, "Ljava/lang/String;"); 
                return;
        }
        out.printf("%sinvokevirtual java/io/PrintStream/println(%s)V\n",indent, i.operand.type.toStringIR());        
    }
    void translate(IRReturn i) {
        if(i.operand != null){
            switch(i.operand.type.typeEnum){
                case INTEGER:
                case CHAR:
                case BOOLEAN:
                    out.printf("%siload %d\n",indent, i.operand.num);
                    out.printf("%sireturn\n",indent);
                    break;
                case FLOAT:
                    out.printf("%sfload %d\n",indent, i.operand.num);
                    out.printf("%sfreturn\n",indent);
                    break;
                case STRING:
                    out.printf("%saload %d\n",indent, i.operand.num);
                    out.printf("%sareturn\n",indent);
                    break; 
            }
        }
        else{
            out.printf("%sreturn\n",indent);
        }
    }
}
