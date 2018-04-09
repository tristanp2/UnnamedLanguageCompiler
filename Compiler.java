/*
 * Compiler.java
 *
 * A starting place for the unamed language compiler for CSC 435/535
 *
 */

import org.antlr.runtime.*;
import java.io.*;
import AST.*;
import Visitor.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Compiler {
    public static void print(Program p){
        ULPrintVisitor pv = new ULPrintVisitor(System.out);
        try{
            p.accept(pv);
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static boolean type_check(Program p){
        TypeCheckVisitor tcv = new TypeCheckVisitor();
        try{
            p.accept(tcv); 
            return true;
        }
        catch(SemanticException se){
            System.out.println(se);
            return false;
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
        return false;
    }
    public static void translate_to_IR(Program p, ArrayList<String> inputPath) {
        String progName = inputPath.get(inputPath.size()-1);
        String irPath = String.join("/", inputPath) + ".ir";
        String progPath = String.join("/", inputPath) + ".j";
        try{
            System.out.println("outputting IR to " + irPath);
            FileOutputStream ios = new FileOutputStream(irPath);
            IRVisitor irv = new IRVisitor(progName, ios);
            p.accept(irv);

            FileOutputStream pos = new FileOutputStream(progPath);
            System.out.println("outputting assembly to " + progPath);
            
            CodeGen cg = new CodeGen(irv.irp, pos);
            cg.generateAssembly();
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static String make_prog_name(String filename) {
        String[] split_f = filename.split("[./]");
        String ret = split_f[split_f.length - 2];
        return ret;
    }
	public static void main (String[] args) throws Exception {
		ANTLRInputStream input;
        boolean do_print = false;

		if (args.length == 0 ) {
			System.out.println("Usage: Test filename.ul [option]");
			return;
		}
		else if (args.length > 1){
            if(args[1].equals("-p"))
                do_print = true;
        }

        input = new ANTLRInputStream(new FileInputStream(args[0]));
        if(args.length > 1){
            do_print = true;
        }
        ArrayList<String> inputFileSplit = new ArrayList<String>(Arrays.asList(args[0].split("[/]")));
        String[] temp = inputFileSplit.get(inputFileSplit.size() - 1).split("[.]");
        String extension = temp[1];
        inputFileSplit.set(inputFileSplit.size() - 1, temp[0]);
        if(!extension.equals("ul")){
            System.out.println(extension + " is not a valid extension. \".ul\" extension required");
            return;
        }

		// The name of the grammar here is "ulwActions",
		// so ANTLR generates ulwActionsLexer and ulwActionsParser
		ulwActionsLexer lexer = new ulwActionsLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ulwActionsParser parser = new ulwActionsParser(tokens);

		try {
            //Repeated calls to parser.program() was causing exception
            //wat it do?
            Program astRoot = parser.program();
            if(do_print){
			    print(astRoot);
            }
            if(type_check(astRoot))
                translate_to_IR(astRoot, inputFileSplit);
		}
		catch (RecognitionException e )	{
			// A lexical or parsing error occured.
			// ANTLR will have already printed information on the
			// console due to code added to the grammar.  So there is
			// nothing to do here.
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
