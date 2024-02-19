#!/bin/sh

if [[ $* = "-u" ]] then
    echo "Uninstalling jcal"
    echo "removing: /usr/bin/jcal.jar"
    echo "removing: /usr/bin/jcal"
    sudo rm  /usr/bin/jcal.jar /usr/bin/jcal
else
    ./build.sh
    sudo cp ./release/*.jar /usr/bin/
    sudo cp ./jcal /usr/bin/
fi
