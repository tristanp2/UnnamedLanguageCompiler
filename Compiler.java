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
    public static void walk(Program p){
        PrintVisitor pv = new PrintVisitor(System.out);
        p.accept(pv); 
    }
	public static void main (String[] args) throws Exception {
		ANTLRInputStream input;

		if (args.length == 0 ) {
			System.out.println("Usage: Test filename.ul");
			return;
		}
		else {
			input = new ANTLRInputStream(new FileInputStream(args[0]));
		}

		// The name of the grammar here is "ulwActions",
		// so ANTLR generates ulwActionsLexer and ulwActionsParser
		ulwActionsLexer lexer = new ulwActionsLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ulwActionsParser parser = new ulwActionsParser(tokens);

		try {
			walk(parser.program());

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
