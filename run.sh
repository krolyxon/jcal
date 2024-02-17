#!/bin/sh
mkdir -p ./bin
ClASSNAME="Calculator"
cd src
javac -d ../bin/ "./$ClASSNAME.java"
java -cp ../bin/ "$ClASSNAME" $*
