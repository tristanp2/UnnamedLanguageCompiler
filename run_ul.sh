BASEDIR=/home/tristan/school/compilers
LIBDIR=$BASEDIR/libs
CLASSPATH=$LIBDIR/jasmin-2708/classes/:$LIBDIR/jasmin-2708/classes/jasmin:$LIBDIR/polyglot-1.3.4/classes/:$LIBDIR/soot-2708/classes/:$LIBDIR/polyglot-1.3.4/cup-classes/:$LIBDIR/antlr-3.0.1/lib/antlr-3.0.1.jar:$LIBDIR/antlr-3.0.1/lib/antlr-runtime-3.0.1.jar:$LIBDIR/antlr-3.0.1/lib/stringtemplate-3.1b1.jar:$LIBDIR/antlr-3.0.1/lib/antlr-2.7.7.jar:./
FILE=$1
IFS="/" read -ra PATHSPLIT <<< "$FILE"
LEN=${#PATHSPLIT[@]}
FILENAME=${PATHSPLIT[$LEN-1]}
IFS="." read -ra FILENAME <<< "$FILENAME"
FILEPATH=$(printf "/%s" "${PATHSPLIT[@]:0:($LEN-1)}")
FILEPATH=${FILEPATH:1}

echo "|"
echo "------------"
echo "File: $FILE"
java -classpath $CLASSPATH Compiler $FILE
./ir_to_class.sh $(printf "%s/%s.ir" "$FILEPATH" "$FILENAME")  
echo "Running generated code"
java $FILENAME
rm $FILENAME".class"
echo ""
echo "------------"
