#!/usr/bin/env bash

F=/application.properties
LOGLEVEL_ROOT=${LOGLEVEL_ROOT:-off}

export LOGLEVEL_ROOT=$LOGLEVEL_ROOT

echo "# LOGGING" >>$F
echo "logger.rootLogger.level = ${LOGLEVEL_ROOT}">>$F
echo "logging.level.org.springframework = ${LOGLEVEL_ROOT}">>$F
