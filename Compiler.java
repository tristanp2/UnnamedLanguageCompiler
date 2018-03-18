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

public class Compiler {
    public static void print(Program p){
        ULPrintVisitor pv = new ULPrintVisitor(System.out);
        p.accept(pv);
    }
    public static void type_check(Program p){
        TypeCheckVisitor tcv = new TypeCheckVisitor();
        try{
            p.accept(tcv); 
        }
        catch(SemanticException se){
            System.out.println(se);
        }
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

		// The name of the grammar here is "ulwActions",
		// so ANTLR generates ulwActionsLexer and ulwActionsParser
		ulwActionsLexer lexer = new ulwActionsLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ulwActionsParser parser = new ulwActionsParser(tokens);

		try {
            if(do_print)
			    print(parser.program());
            else
                type_check(parser.program());

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
