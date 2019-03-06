#!/usr/bin/env bash

F=/application.properties
if [ ! -z ${LOGLEVEL_APP} ]; then
    export ENVTYPE=env
    echo "logging.level.de.mgeo = ${LOGLEVEL_APP}">>$F
fi
