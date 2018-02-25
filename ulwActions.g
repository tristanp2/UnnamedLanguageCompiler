//Grammar for Unnamed Language
//
//Tristan Partridge
//V00804280
//



grammar ulwActions;


@header
{
    import AST.*;
    import Types.*;
}
				
@members
{

    protected void mismatch (IntStream input, int ttype, BitSet follow)
            throws RecognitionException
    {
            throw new MismatchedTokenException(ttype, input);
    }
    public void recoverFromMismatchedSet (IntStream input,
                                          RecognitionException e,
                                          BitSet follow)
            throws RecognitionException
    {
            reportError(e);
            throw e;
    }
}

@rulecatch {
        catch (RecognitionException ex) {
                reportError(ex);
                throw ex;
        }
}
program returns [Program p]
@init
{
    p = new Program();
}
    :
    (f=function {p.addElement(f);})+ EOF
	;

function returns [Function f]: 
    fd=functionDec1 fb=functionBody {f = new Function(fd, fb);}
    ;

//given grammar does not allow func dec without params but sample program does,
//so making assumption it is allowed
functionDec1 returns [FunctionDeclaration fd] 
    :
    ct=compoundType i=id '(' fp=formalParameters ')' { fd = new FunctionDeclaration(ct, i, fp);}
    | ct2=compoundType i2=id '(' ')' {fd = new FunctionDeclaration(ct2, i2, null);}
    ;

functionBody returns [FunctionBody fb]  
@init{
    fb = new FunctionBody();
}
    :
    '{' (vd=varDec1 {fb.addDeclaration(vd);})* (s=statement {fb.addStatement(s);})* '}'
    ;

formalParameters returns [FormalParameterList fpl]
@init{
    fpl = new FormalParameterList();
}
    : 
    ct=compoundType i=id { fpl.addElement(new FormalParameter(ct,i)); } 
        (',' ct2=compoundType i2=id {fpl.addElement(new FormalParameter(ct2,i2));})* 
    ;

varDec1 returns [VariableDeclaration vd]:
    ct=compoundType i=id ';' {vd = new VariableDeclaration(ct, i);}
    ;

compoundType returns [TypeNode t]: 
    t1=type {t = t1;}
    | et=type '[' i=intLit ']' {t = new TypeNode(new ArrayType(et.getType(), i.getVal()), 
                                                                et.getLineNum(), 
                                                                et.getOffset());
                               }
    ;

type returns [TypeNode tn]:
    t=TYPEINT       {tn =   new TypeNode(
                            new IntegerType(),
                            t.getLine(),
                            t.getCharPositionInLine());
                    }
    | t=TYPEFLOAT   {tn =   new TypeNode(
                            new FloatType(),
                            t.getLine(),
                            t.getCharPositionInLine());
                    }
    | t=TYPECHAR    {tn =   new TypeNode(
                            new CharType(),
                            t.getLine(),
                            t.getCharPositionInLine());                    
                    }
    | t=TYPESTRING  {tn =   new TypeNode(
                            new StringType(),
                            t.getLine(),
                            t.getCharPositionInLine());
                    }
    | t=TYPEBOOLEAN {tn =   new TypeNode(
                            new BooleanType(),
                            t.getLine(),
                            t.getCharPositionInLine());
                    }
    | t=TYPEVOID    {tn =   new TypeNode(
                            new VoidType(),
                            t.getLine(),
                            t.getCharPositionInLine());
                    }
    ;


//backtrack is necessary because array index assignment
//looks same as array index expression
statement returns [Statement s] options {backtrack=true;} :
    ';' {s = new EmptyStatement();}
    | e=expr ';' {s = new ExpressionStatement(e);}
    | a=assignment {s = a;}
    | i=ifStatement {s = i;}
    | w=whileStatement {s = w;}
    | p=printStatement {s = p;}
    | r=returnStatement {s = r;}
    ;
assignment returns [AssignmentStatement as]:
    i=id '[' e1=expr ']' '=' e2=expr ';' {as = new ArrayAssignment(i, e1, e2);} 
    | i=id '=' e1=expr ';'  {as = new VariableAssignment(i, e1);}
    ;
    

ifStatement returns [IfStatement is] options {backtrack = true;}:
    IF '(' c=expr ')' b1=block ELSE b2=block {is = new IfStatement(c, b1, b2);}
    | IF '(' c=expr ')' b1=block    {is = new IfStatement(c, b1);}
    ;

whileStatement returns [WhileStatement ws]:
    WHILE '(' e=expr ')' b=block {ws = new WhileStatement(e, b);} 
    ;

printStatement returns [Statement s]:
    PRINT e=expr ';' {s = new PrintStatement(e);}
    | PRINTLN e=expr ';' {s = new PrintLnStatement(e);}
    ;
    
returnStatement returns [ReturnStatement rs]:
    RETURN ';' {rs = new ReturnStatement(null);}
    | RETURN e=expr ';' {rs = new ReturnStatement(e);}
    ;

block returns [Block b]
@init{
    b = new Block();
}
    :
    '{' (s=statement {b.addElement(s);})* '}'
    ;

exprList returns [ExpressionList el]
@init{
    el = new ExpressionList();
}
    :
    e1=expr {el.addElement(e1);} (',' e2=expr {el.addElement(e2);})*
    ;

expr returns [EqualityExpression ee] options {backtrack=true;}:
    e1=lessExpr EQUAL e2=lessExpr {ee = new EqualityExpression(e1,e2);}
    | e1=lessExpr {ee = new EqualityExpression(e1,null);} 
    ;
lessExpr returns [LessThanExpression le] options {backtrack=true;}:
    e1=addSubExpr LESS e2=lessExpr {le = new LessThanExpression(e1,e2);}
    | e1=addSubExpr {le = new LessThanExpression(e1,null);}
    ;
addSubExpr returns [Expression ae] options {backtrack=true;}:
    e1=multExpr PLUS e2=addSubExpr {ae = new AddExpression(e1,e2);}
    | e1=multExpr MINUS e2=addSubExpr {ae = new SubtractExpression(e1,e2);}
    | e1=multExpr {ae = new AddExpression(e1, null);}
    ;
multExpr returns [MultExpression me] options {backtrack=true;}:
    e1=unaryExpr MULT e2=multExpr {me = new MultExpression(e1,e2);}
    | e1=unaryExpr {me = new MultExpression(e1,null);}
    ;
unaryExpr returns [UnaryExpression ue]:
    MINUS e1=primExpr {ue = new UnaryExpression(e1, true);}
    | e1=primExpr {ue =  new UnaryExpression(e1, false);}
;
//should types be restricted depending on expression?
//assuming no for now, since grammar doesn't mention it
primExpr returns [Expression e] options {backtrack=true;}:
    i=id '(' el=exprList ')' {e = new FunctionCall(i,el); }
    | i=id '(' ')' {e = new FunctionCall(i,null);}
    | '(' e1=expr ')' {e = new ParenExpression(e1);} 
    | i=id '[' e1=expr ']' {e = new ArrayReference(i, e1);}
    | i=id {e = new IdentifierValue(i);}
    | e1=literal {e = e1; }
    ;

id returns [Identifier i]:
    ID {i = new Identifier($ID.text,$ID.getLine(),$ID.getCharPositionInLine());}
    ;

literal returns [Expression e]:
    il=intLit {e = il;}
    | fl=floatLit {e = fl;}
    | cl=charLit {e = cl;}
    | sl=stringLit {e = sl;}
    | bl=boolLit {e = bl;}
    ;

intLit returns [IntegerLiteral il]:
    INT {il = new IntegerLiteral(Integer.parseInt($INT.text),$INT.getLine(),
                                $INT.getCharPositionInLine());}
    ;
floatLit returns [FloatLiteral fl]:
    FLOAT {fl = new FloatLiteral(Float.parseFloat($FLOAT.text),$FLOAT.getLine(),
                                    $FLOAT.getCharPositionInLine());}
    ;
charLit returns [CharacterLiteral cl]:
    CHAR {cl = new CharacterLiteral($CHAR.text.charAt(1),$CHAR.getLine(),
                                $CHAR.getCharPositionInLine());}
    ;
stringLit returns [StringLiteral sl]:
    STRING {int len=$STRING.text.length(); 
            sl = new StringLiteral($STRING.text.substring(1,len-1),
                                    $STRING.getLine(), $STRING.getCharPositionInLine());}
    ;
boolLit returns [BooleanLiteral bl]:
    BOOLEAN {bl = new BooleanLiteral(Boolean.parseBoolean($BOOLEAN.text),
                                        $BOOLEAN.getLine(),$BOOLEAN.getCharPositionInLine());}
    ;



/* Lexer */
	 
IF	    : 'if'
	    ;
ELSE    : 'else'
        ;
WHILE   : 'while'
        ;

PRINT   : 'print'
        ;
PRINTLN : 'println'
        ;
RETURN  : 'return'
        ;
PLUS    : '+'
        ;
MINUS   : '-'
        ;
MULT    : '*'
        ;
EQUAL   : '=='
        ;
LESS    : '<'
        ;
BOOLEAN : ('true' | 'false')
        ;

TYPEINT : 'int'
        ;
TYPEFLOAT : 'float'
        ;
TYPECHAR : 'char'
        ;
TYPESTRING : 'string'
        ;
TYPEBOOLEAN : 'boolean'
        ;
TYPEVOID : 'void'
        ;

CHAR    : '\u0027' . '\u0027' ;

STRING  : '\u0022' .* '\u0022';

ID	: (('a'..'z')|('A'..'Z'))(('a'..'z')|('A'..'Z')|('0'..'9')|('_'))*;

INT     : ('0' | ('1'..'9'('0'..'9')*)) ;

FLOAT   : ('0'..'9')+'.'('0'..'9')+('('('0'..'9')+')')? ;


WS      : ( '\t' | ' ' | '\r' | '\n')+ { $channel = HIDDEN; } ;

COMMENT : '//' ~('\r' | '\n')* ('\r' | '\n') { $channel = HIDDEN; } ;

