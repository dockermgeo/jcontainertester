#!/usr/bin/env bash

F=/application.properties
HTML_TITLE=${HTML_TITLE:-"Workshop jTester"}

if [ -f $F ]; then
    rm -f $F
fi

echo "# Autogen by Docker.boot">>$F
echo "de.mgeo.title=${HTML_TITLE}" >>$F
