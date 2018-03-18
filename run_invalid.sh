#!/bin/bash

TEST_DIR="./typing_tests/provided_tests/"

for test_file in $TEST_DIR/*_invalid*.ul; do
    echo "|"
    echo "------------"
    echo "Test file: $test_file"
    java Compiler $test_file
    echo "------------"
done
