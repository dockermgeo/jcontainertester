#!/usr/bin/env bash

F=/application.properties
VOL=/secrets

if [ -d ${VOL} ]; then
    export ENVTYPE=secret
    source ${VOL}/logging.properties
    export LOGLEVEL_APP=${LOGLEVEL_APP}
    echo "logging.level.de.mgeo = ${LOGLEVEL_APP}">>$F
fi
