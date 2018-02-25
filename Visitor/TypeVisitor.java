package Visitor;
import Types.*;
import AST.*;

public interface TypeVisitor{
	public Type visit (AddExpression e) throws SemanticException;
	public Type visit (ArrayType a) throws SemanticException;
	public Type visit (ArrayAssignment s) throws SemanticException;
	public Type visit (ArrayReference a) throws SemanticException;
	public Type visit (Block b) throws SemanticException;
	public Type visit (BooleanLiteral b) throws SemanticException;
	public Type visit (CharacterLiteral c) throws SemanticException;
	public Type visit (EqualityExpression e) throws SemanticException;
	public Type visit (ExpressionStatement e) throws SemanticException;
	public Type visit (FloatLiteral f) throws SemanticException;	
	public Type visit (FormalParameter p) throws SemanticException;
	public Type visit (Function f) throws SemanticException;
	public Type visit (FunctionBody f) throws SemanticException;
	public Type visit (FunctionCall f) throws SemanticException;
	public Type visit (FunctionDeclaration f) throws SemanticException;
	public Type visit (Identifier i) throws SemanticException;
	public Type visit (IdentifierValue v) throws SemanticException;
	public Type visit (IfStatement i) throws SemanticException;
	public Type visit (IntegerLiteral i) throws SemanticException;
	public Type visit (LessThanExpression e) throws SemanticException;
	public Type visit (MultExpression e) throws SemanticException;
	public Type visit (ParenExpression p) throws SemanticException;
	public Type visit (PrintLnStatement s) throws SemanticException;
	public Type visit (PrintStatement s) throws SemanticException;	
	public Type visit (Program p) throws SemanticException;
	public Type visit (ReturnStatement s) throws SemanticException;
	public Type visit (StringLiteral s) throws SemanticException;
	public Type visit (SubtractExpression e) throws SemanticException;
	public Type visit (Type t) throws SemanticException;
	public Type visit (TypeNode t) throws SemanticException;
	public Type visit (VariableAssignment s) throws SemanticException;
	public Type visit (VariableDeclaration v) throws SemanticException;
	public Type visit (WhileStatement s) throws SemanticException;
}
