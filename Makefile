#
GNAME= ulwActions
GSRC= $(GNAME).g
LIBDIR= /home/tristan/school/compilers/libs
CLASSPATH= "$(LIBDIR)/jasmin-2708/classes/:$(LIBDIR)/polyglot-1.3.4/classes/:$(LIBDIR)/soot-2708/classes/:$(LIBDIR)/polyglot-1.3.4/cup-classes/:$(LIBDIR)/antlr-3.0.1/lib/antlr-3.0.1.jar:$(LIBDIR)/antlr-3.0.1/lib/antlr-runtime-3.0.1.jar:$(LIBDIR)/antlr-3.0.1/lib/stringtemplate-3.1b1.jar:$(LIBDIR)/antlr-3.0.1/lib/antlr-2.7.7.jar:./"

all: grammar compiler

grammar: $(GSRCS)
	java -cp $(CLASSPATH) org.antlr.Tool -fo . $(GSRC) 

compiler:
	javac -cp $(CLASSPATH) *.java AST/*.java Types/*.java

clean:
	rm *.class AST/*.class Types/*.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens


 
