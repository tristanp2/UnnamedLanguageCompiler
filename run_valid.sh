#!/bin/bash

TEST_DIR="./provided_tests/withoutSubtypes"

for test_file in $TEST_DIR/*_valid*.ul; do
    echo "|"
    echo "------------"
    echo "Test file: $test_file"
    java Compiler $test_file
    echo "------------"
done
