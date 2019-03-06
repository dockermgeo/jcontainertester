#!/usr/bin/env bash

F=/application.properties
if [ ! -z ${LOGLEVEL_DOMAIN} ]; then
    export LOGLEVEL_APP=${LOGLEVEL_DOMAIN}
    export ENVTYPE=configmap
    echo "logging.level.de.mgeo = ${LOGLEVEL_APP}">>$F
fi
