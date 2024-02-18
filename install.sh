#!/bin/sh

if [[ $* = "-u" ]] then
    echo "Uninstalling JavaCalc"
    echo "removing: /usr/bin/JavaCalc"
    echo "removing: /usr/bin/jcal"
    sudo rm  /usr/bin/JavaCalc.jar /usr/bin/jcal
else
    ./build.sh
    sudo cp ./release/*.jar /usr/bin/
    sudo cp ./jcal /usr/bin/
fi
