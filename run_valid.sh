#!/bin/bash

TEST_DIR="./typing_tests/provided_tests/"
FILES=$TEST_DIR/*_valid*.ul
for test_file in $FILES; do
    echo "|"
    echo "------------"
    echo "Test file: $test_file"
    java Compiler $test_file
    echo "------------"
done
