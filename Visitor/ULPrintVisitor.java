package Visitor;
import Types.*;
import AST.*;
import java.io.*;

public class ULPrintVisitor implements BaseVisitor{
    int indentation = 0;
    PrintStream out;

    public ULPrintVisitor(OutputStream os){
        this.out = new PrintStream(os);
    }
    public ULPrintVisitor(File f){
        try{
            this.out = new PrintStream(f);
        }
        catch(FileNotFoundException e){
            System.out.println("abort");
            System.exit(1);
        }
    }

    public Object visit(AddExpression ae)throws Exception{
        ae.expr1.accept(this);
        if(ae.expr2 != null){
            out.print("+");
            ae.expr2.accept(this);
        }
        return null;
    }

    public Object visit(ArrayAssignment aa)throws Exception{
       printIndent();
       aa.id.accept(this);
       out.print("[");
       aa.index.accept(this);
       out.print("]=");
       aa.expr.accept(this); 
       out.println(";");
        return null;
    }
    public Object visit(ArrayReference ar)throws Exception{
       ar.id.accept(this);
       out.print("[");
       ar.index.accept(this);
       out.print("]");
        return null;
    }
    public Object visit(Block b)throws Exception{
        printIndent();
        out.println("{");
        indentation++;
        int size = b.size();
        for(int i=0; i<size; i++){
            b.elementAt(i).accept(this);
        }
        indentation--;
        printIndent();
        out.println("}");
        return null;
    }
    public Object visit(BooleanLiteral bl) throws Exception{
        out.print(bl.val);
        return null;
    }
    public Object visit(CharacterLiteral cl) throws Exception{
        out.print("\'" + cl.val + "\'");
        return null;
    }
    public Object visit(EmptyStatement es) throws Exception{
        printIndent();
        out.println(";");
        return null;
    }
    public Object visit(EqualityExpression ee) throws Exception{
        ee.expr1.accept(this);
        if(ee.expr2 != null){
            out.print("==");
            ee.expr2.accept(this);
        }
        return null;
    }
    public Object visit(ExpressionList el) throws Exception{
        int size = el.size();
        for(int i=0; i<size - 1; i++){
            el.elementAt(i).accept(this);
            out.print(", ");
        }
        el.elementAt(size-1).accept(this);
        return null;
    }
    public Object visit(ExpressionStatement es) throws Exception{
        printIndent();
        es.expr.accept(this);
        out.println(";");
        return null;
    }
    public Object visit(FloatLiteral fl) throws Exception{
        out.print(fl.val);
        return null;
    }
    public Object visit(FormalParameter fp) throws Exception{
        fp.type.accept(this);
        out.print(" ");
        fp.id.accept(this);
        return null;
    }
    public Object visit(FormalParameterList fpl) throws Exception{
        int size = fpl.size();
        for(int i=0; i<size - 1; i++){
            fpl.elementAt(i).accept(this);
            out.print(", ");
        }
        fpl.elementAt(size-1).accept(this);
        return null;
    }
    public Object visit(FunctionBody fb) throws Exception{
        indentation++;
        out.println("{");
        int decSize = fb.declarationSize(), statSize = fb.statementSize();
        
        for(int i=0; i<decSize; i++){
            fb.declarationAt(i).accept(this);
        }
        if(decSize>0)
            out.println();
        for(int i=0; i<statSize; i++){
            fb.statementAt(i).accept(this);
        }

        indentation--;
        out.println("}");
        return null;
    }
    public Object visit(FunctionCall fc) throws Exception{
        fc.id.accept(this);
        out.print("(");
        if(fc.exprList != null)
            fc.exprList.accept(this);
        out.print(")");
        return null;
    }
    public Object visit(FunctionDeclaration fd) throws Exception{
        fd.type.accept(this);
        out.print(" ");
        fd.id.accept(this);
        out.print(" (");
        if(fd.paramList != null) fd.paramList.accept(this);
        out.print(")");
        return null;
    }
    public Object visit(Function f) throws Exception{
        f.funcDec.accept(this);
        out.println();
        f.funcBody.accept(this);
        return null;
    }
    public Object visit(Identifier i) throws Exception{
        out.print(i.name);
        return null;
    }
    public Object visit(IdentifierValue iv) throws Exception{
        iv.id.accept(this);
        return null;
    }
    public Object visit(IfStatement is) throws Exception{
        printIndent();
        out.print("if (");
        is.condition.accept(this);
        out.println(")");
        is.ifBlock.accept(this);
        if(is.elseBlock != null){
            printIndent();
            out.println("else");
            is.elseBlock.accept(this);
        }
        return null;
    }
    public Object visit(IntegerLiteral il) throws Exception{
        out.print(il.val);
        return null;
    }
    public Object visit(LessThanExpression lte) throws Exception{
        lte.expr1.accept(this);
        if(lte.expr2 != null){
            out.print("<");
            lte.expr2.accept(this);
        }
        return null;
    }
    public Object visit(MultExpression me) throws Exception{
        me.expr1.accept(this);
        if(me.expr2 != null){
            out.print("*");
            me.expr2.accept(this);
        }
        return null;
    }
    public Object visit(ParenExpression pe) throws Exception{
        out.print("(");
        pe.expr.accept(this);
        out.print(")");
        return null;
    }
    public Object visit(PrintLnStatement pls) throws Exception{
        printIndent();
        out.print(pls.toString() + " ");
        pls.expr.accept(this);
        out.println(";");
        return null;
    }
    public Object visit(PrintStatement ps) throws Exception{
        printIndent();
        out.print(ps.toString() + " ");
        ps.expr.accept(this);
        out.println(";");
        return null;
    }
    public Object visit(Program p) throws Exception{
        int size = p.size();
        for(int i=0; i<size; i++){
            p.elementAt(i).accept(this);
            if(i != size-1)
                out.println();
        }
        return null;
    }
    public Object visit(ReturnStatement rs) throws Exception{
        printIndent();
        out.print(rs.toString());
        if(rs.expr != null){
            out.print(" ");
            rs.expr.accept(this);
        }
        out.println(";");
        return null;
    }
    public Object visit(StringLiteral sl) throws Exception{
        out.print("\"" + sl.val + "\"");
        return null;
    }
    public Object visit(SubtractExpression se) throws Exception{
        se.expr1.accept(this);
        out.print("-");
        se.expr2.accept(this);
        return null;
    }
    public Object visit(TypeNode tn) throws Exception{
        tn.type.accept(this);
        return null;
    }
    public Object visit(UnaryExpression ue) throws Exception{
        if(ue.negated())
            out.print("-");

        ue.expr.accept(this);
        return null;
    }
    public Object visit(VariableAssignment va) throws Exception{
        printIndent();
        va.id.accept(this);
        out.print("=");
        va.expr.accept(this);
        out.println(";");
        return null;
    }
    public Object visit(VariableDeclaration vd) throws Exception{
        printIndent();
        vd.type.accept(this);
        out.print(" ");
        vd.id.accept(this);
        out.println(";");
        return null;
    }
    public Object visit(WhileStatement ws) throws Exception{
        printIndent();
        out.print(ws.toString());
        out.print(" (");
        ws.condition.accept(this);
        out.println(")");
        ws.body.accept(this);
        return null;
    }
    public Object visit(Type t) throws Exception{
        return null;
    }
    public Object visit(ArrayType at) throws Exception{
        out.print(at.toString());
        return null;
    }
    public Object visit(BooleanType bt) throws Exception{
        out.print(bt.toString());
        return null;
    }
    public Object visit(CharType ct) throws Exception{
        out.print(ct.toString());
        return null;
    }
    public Object visit(FloatType ft) throws Exception{
        out.print(ft.toString());
        return null;
    }
    public Object visit(IntegerType it) throws Exception{
        out.print(it.toString());
        return null;
    }
    public Object visit(StringType st) throws Exception{
        out.print(st.toString());
        return null;
    }
    public Object visit(VoidType vt) throws Exception{
        out.print(vt.toString());
        return null;
    }
    public Object printIndent(){
        for(int i = 0; i < indentation; i++){
            out.print("    ");
        }
        return null;
    }
}
