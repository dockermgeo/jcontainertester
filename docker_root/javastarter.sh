#!/usr/bin/env bash

for script in $(ls /boot.d/*.sh); do
    chmod a+x $script
    . $script
done

java -jar /app.jar