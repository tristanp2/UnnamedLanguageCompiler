#!/bin/bash
BASEDIR=/home/tristan/school/compilers
PROJECTDIR=$BASEDIR/project
LIBDIR=$BASEDIR/libs
CLASSPATH=$LIBDIR/jasmin-2708/classes/:$LIBDIR/jasmin-2708/classes/jasmin:$LIBDIR/polyglot-1.3.4/classes/:$LIBDIR/soot-2708/classes/:$LIBDIR/polyglot-1.3.4/cup-classes/:$LIBDIR/antlr-3.0.1/lib/antlr-3.0.1.jar:$LIBDIR/antlr-3.0.1/lib/antlr-runtime-3.0.1.jar:$LIBDIR/antlr-3.0.1/lib/stringtemplate-3.1b1.jar:$LIBDIR/antlr-3.0.1/lib/antlr-2.7.7.jar:./
ARG=$1
IFS="/" read -ra PATHSPLIT <<< "$ARG"
LEN=${#PATHSPLIT[@]}
FILEPATH=$(printf "/%s" "${PATHSPLIT[@]:0:($LEN-1)}")
FILEPATH=${FILEPATH:1}

IFS="." read -ra NAMESPLIT <<< "${PATHSPLIT[-1]}"
OUTNAME=${NAMESPLIT[0]}".j"

echo "Running codegen..."
$PROJECTDIR/stage/codegen_tests/codegen/codegen --file=$ARG > $FILEPATH"/"$OUTNAME

echo "Assembling..."
java -classpath $CLASSPATH jasmin.Main $FILEPATH"/"$OUTNAME 

