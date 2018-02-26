#
GNAME= ulwActions
GSRC= $(GNAME).g

all: grammar compiler

grammar: $(GSRCS)
	java org.antlr.Tool -Xconversiontimeout 10000 -fo . $(GSRC) 

compiler:
	javac *.java AST/*.java Visitor/*.java Types/*.java Environment/*.java

clean:
	rm *.class AST/*.class Visitor/*.class Types/*.class Environment/*.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens


 
