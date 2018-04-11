#!/bin/bash


LIBDIR=/home/tristan/school/compilers/libs
CLASSPATH=$LIBDIR/jasmin-2708/classes/:$LIBDIR/jasmin-2708/classes/jasmin:$LIBDIR/polyglot-1.3.4/classes/:$LIBDIR/soot-2708/classes/:$LIBDIR/polyglot-1.3.4/cup-classes/:$LIBDIR/antlr-3.0.1/lib/antlr-3.0.1.jar:$LIBDIR/antlr-3.0.1/lib/antlr-runtime-3.0.1.jar:$LIBDIR/antlr-3.0.1/lib/stringtemplate-3.1b1.jar:$LIBDIR/antlr-3.0.1/lib/antlr-2.7.7.jar:./

for file in ./codegen_tests/*.ul; do
    IFS="/" read -ra FILESPLIT <<< "$file"
    IFS="." read -ra BASENAME <<< "${FILESPLIT[-1]}"

    echo "|"
    echo "FILE=$BASENAME"
    echo "generating IR..."
    java -classpath $CLASSPATH Compiler $file > "./$BASENAME.ir"
    echo "converting IR to JVM assembly..."
    ./codegen_tests/codegen/codegen --file=./"$BASENAME.ir" > "$BASENAME.j"
    echo "assembling..."
    java -classpath $CLASSPATH jasmin.Main "$BASENAME.j"
    echo "running..."
    java $BASENAME 
   # rm "$BASENAME.ir" "$BASENAME.j" "$BASENAME.class"
    echo "|"
done
