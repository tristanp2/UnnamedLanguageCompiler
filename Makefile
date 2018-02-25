#
GNAME= ulwActions
GSRC= $(GNAME).g

all: grammar compiler

grammar: $(GSRCS)
	java org.antlr.Tool -fo . $(GSRC) 

compiler:
	javac *.java AST/*.java Visitor/*.java Types/*.java

clean:
	rm *.class AST/*.class Visitor/*.class Semantic/*.class Types/*.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens


 
