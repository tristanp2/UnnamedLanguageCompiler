#
GNAME= ulwActions
GSRC= $(GNAME).g

all: grammar compiler

grammar: $(GSRCS)
	java org.antlr.Tool -Xconversiontimeout 10000 -fo . $(GSRC) 

compiler:
	javac *.java AST/*.java Visitor/*.java Types/*.java Environment/*.java IR/*.java

clean:
	rm *.class AST/*.class Visitor/*.class Types/*.class Environment/*.class IR/*.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens


 
