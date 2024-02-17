#!/bin/sh
mkdir -p release
javac -d ./bin src/*.java
jar cvmf manifest.mf ./release/JavaCalc.jar -C ./bin .
