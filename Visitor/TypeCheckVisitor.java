package Visitor;
import AST.*;
import Types.*;

public class TypeCheckVisitor implements TypeVisitor{
	public Type visit (AddExpression e) throws SemanticException{
        return null;
    }
	public Type visit (ArrayType a) throws SemanticException{
        return null;
    }
	public Type visit (ArrayAssignment s) throws SemanticException{
        return null;
    }
	public Type visit (ArrayReference a) throws SemanticException{
        return null;
    }
	public Type visit (Block b) throws SemanticException{
        return null;
    }
	public Type visit (BooleanLiteral b) throws SemanticException{
        return null;
    }
	public Type visit (CharacterLiteral c) throws SemanticException{
        return null;
    }
	public Type visit (EqualityExpression e) throws SemanticException{
        return null;
    }
	public Type visit (ExpressionStatement e) throws SemanticException{
        return null;
    }
	public Type visit (FloatLiteral f) throws SemanticException{
        return null;
    }	
	public Type visit (FormalParameter p) throws SemanticException{
        return null;
    }
	public Type visit (Function f) throws SemanticException{
        return null;
    }
	public Type visit (FunctionBody f) throws SemanticException{
        return null;
    }
	public Type visit (FunctionCall f) throws SemanticException{
        return null;
    }
	public Type visit (FunctionDeclaration f) throws SemanticException{
        return null;
    }
	public Type visit (Identifier i) throws SemanticException{
        return null;
    }
	public Type visit (IdentifierValue v) throws SemanticException{
        return null;
    }
	public Type visit (IfStatement i) throws SemanticException{
        return null;
    }
	public Type visit (IntegerLiteral i) throws SemanticException{
        return null;
    }
	public Type visit (LessThanExpression e) throws SemanticException{
        return null;
    }
	public Type visit (MultExpression e) throws SemanticException{
        return null;
    }
	public Type visit (ParenExpression p) throws SemanticException{
        return null;
    }
	public Type visit (PrintLnStatement s) throws SemanticException{
        return null;
    }
	public Type visit (PrintStatement s) throws SemanticException{
        return null;
    }	
	public Type visit (Program p) throws SemanticException{
        return null;
    }
	public Type visit (ReturnStatement s) throws SemanticException{
        return null;
    }
	public Type visit (StringLiteral s) throws SemanticException{
        return null;
    }
	public Type visit (SubtractExpression e) throws SemanticException{
        return null;
    }
	public Type visit (Type t) throws SemanticException{
        return null;
    }
	public Type visit (TypeNode t) throws SemanticException{
        return null;
    }
	public Type visit (VariableAssignment s) throws SemanticException{
        return null;
    }
	public Type visit (VariableDeclaration v) throws SemanticException{
        return null;
    }
	public Type visit (WhileStatement s) throws SemanticException{
        return null;
    }
}

