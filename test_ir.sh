#!/bin/bash

BASEDIR=/home/tristan/school/compilers
PROJECTDIR=$BASEDIR/project

for file in $PROJECTDIR/stage/codegen_tests/*.ul; do 
    ./run_ul.sh $file
done
