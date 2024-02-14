#!/bin/sh
mkdir -p ./bin
ClASSNAME="Calculator"
javac -d ./bin/ "./$ClASSNAME.java"
java -cp ./bin/ "$ClASSNAME" $*
