#!/usr/bin/env bash

for script in $(ls /boot.d/*.sh); do
    . $script
done

java -jar /app.jar