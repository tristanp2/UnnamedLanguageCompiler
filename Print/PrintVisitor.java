package Print;
import Types.*;
import AST.*;
import java.io.*;

public class PrintVisitor implements VoidVisitor{
    int indentation = 0;
    PrintStream out;

    public PrintVisitor(OutputStream os){
        this.out = new PrintStream(os);
    }
    public PrintVisitor(File f){
        try{
            this.out = new PrintStream(f);
        }
        catch(FileNotFoundException e){
            System.out.println("abort");
            System.exit(1);
        }
    }

    public void visit(AddExpression ae){
        ae.expr1.accept(this);
        if(ae.expr2 != null){
            out.print("+");
            ae.expr2.accept(this);
        }
    }

    public void visit(ArrayAssignment aa){
       printIndent();
       aa.id.accept(this);
       out.print("[");
       aa.index.accept(this);
       out.print("]=");
       aa.expr.accept(this); 
       out.println(";");
    }
    public void visit(ArrayReference ar){
       ar.id.accept(this);
       out.print("[");
       ar.index.accept(this);
       out.print("]");
    }
    public void visit(Block b){
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
    }
    public void visit(BooleanLiteral bl){
        out.print(bl.val);
    }
    public void visit(CharacterLiteral cl){
        out.print("\'" + cl.val + "\'");
    }
    public void visit(EmptyStatement es){
        printIndent();
        out.println(";");
    }
    public void visit(EqualityExpression ee){
        ee.expr1.accept(this);
        if(ee.expr2 != null){
            out.print("==");
            ee.expr2.accept(this);
        }
    }
    public void visit(ExpressionList el){
        int size = el.size();
        for(int i=0; i<size - 1; i++){
            el.elementAt(i).accept(this);
            out.print(", ");
        }
        el.elementAt(size-1).accept(this);
    }
    public void visit(ExpressionStatement es){
        printIndent();
        es.expr.accept(this);
        out.println(";");
    }
    public void visit(FloatLiteral fl){
        out.print(fl.val);
    }
    public void visit(FormalParameter fp){
        fp.type.accept(this);
        out.print(" ");
        fp.id.accept(this);
    }
    public void visit(FormalParameterList fpl){
        int size = fpl.size();
        for(int i=0; i<size - 1; i++){
            fpl.elementAt(i).accept(this);
            out.print(", ");
        }
        fpl.elementAt(size-1).accept(this);
    }
    public void visit(FunctionBody fb){
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
    }
    public void visit(FunctionCall fc){
        fc.id.accept(this);
        out.print("(");
        if(fc.exprList != null)
            fc.exprList.accept(this);
        out.print(")");
    }
    public void visit(FunctionDeclaration fd){
        fd.type.accept(this);
        out.print(" ");
        fd.id.accept(this);
        out.print(" (");
        if(fd.paramList != null) fd.paramList.accept(this);
        out.print(")");
    }
    public void visit(Function f){
        f.funcDec.accept(this);
        out.println();
        f.funcBody.accept(this);
    }
    public void visit(Identifier i){
        out.print(i.name);
    }
    public void visit(IdentifierValue iv){
        iv.id.accept(this);
    }
    public void visit(IfStatement is){
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
    }
    public void visit(IntegerLiteral il){
        out.print(il.val);
    }
    public void visit(LessThanExpression lte){
        lte.expr1.accept(this);
        if(lte.expr2 != null){
            out.print("<");
            lte.expr2.accept(this);
        }
    }
    public void visit(MultExpression me){
        me.expr1.accept(this);
        if(me.expr2 != null){
            out.print("*");
            me.expr2.accept(this);
        }
    }
    public void visit(ParenExpression pe){
        out.print("(");
        pe.expr.accept(this);
        out.print(")");
    }
    public void visit(PrintLnStatement pls){
        printIndent();
        out.print(pls.toString() + " ");
        pls.expr.accept(this);
        out.println(";");
    }
    public void visit(PrintStatement ps){
        printIndent();
        out.print(ps.toString() + " ");
        ps.expr.accept(this);
        out.println(";");
    }
    public void visit(Program p){
        int size = p.size();
        for(int i=0; i<size; i++){
            p.elementAt(i).accept(this);
            if(i != size-1)
                out.println();
        }
    }
    public void visit(ReturnStatement rs){
        printIndent();
        out.print(rs.toString());
        if(rs.expr != null){
            out.print(" ");
            rs.expr.accept(this);
        }
        out.println(";");
    }
    public void visit(StringLiteral sl){
        out.print("\"" + sl.val + "\"");
    }
    public void visit(SubtractExpression se){
        se.expr1.accept(this);
        out.print("-");
        se.expr2.accept(this);
    }
    public void visit(TypeNode tn){
        tn.type.accept(this);
    }
    public void visit(UnaryExpression ue){
        if(ue.negated())
            out.print("-");

        ue.expr.accept(this);
    }
    public void visit(VariableAssignment va){
        printIndent();
        va.id.accept(this);
        out.print("=");
        va.expr.accept(this);
        out.println(";");
    }
    public void visit(VariableDeclaration vd){
        printIndent();
        vd.type.accept(this);
        out.print(" ");
        vd.id.accept(this);
        out.println(";");
    }
    public void visit(WhileStatement ws){
        printIndent();
        out.print(ws.toString());
        out.print(" (");
        ws.condition.accept(this);
        out.println(")");
        ws.body.accept(this);
    }
    public void visit(Type t){
    }
    public void visit(ArrayType at){
        out.print(at.toString());
    }
    public void visit(BooleanType bt){
        out.print(bt.toString());
    }
    public void visit(CharType ct){
        out.print(ct.toString());
    }
    public void visit(FloatType ft){
        out.print(ft.toString());
    }
    public void visit(IntegerType it){
        out.print(it.toString());
    }
    public void visit(StringType st){
        out.print(st.toString());
    }
    public void visit(VoidType vt){
        out.print(vt.toString());
    }
    public void printIndent(){
        for(int i = 0; i < indentation; i++){
            out.print("    ");
        }
    }
}
