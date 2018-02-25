#
GNAME= ulwActions
GSRC= $(GNAME).g

all: grammar compiler

grammar: $(GSRCS)
	java org.antlr.Tool -fo . $(GSRC) 

compiler:
	javac *.java AST/*.java Print/*.java Types/*.java

clean:
	rm *.class AST/*.class Print/*.class Semantic/*.class Types/*.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens


 
