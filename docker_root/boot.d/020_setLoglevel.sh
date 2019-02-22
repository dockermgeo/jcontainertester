#!/usr/bin/env bash

F=/application.properties
LOGLEVEL=${LOG_LEVEL:-error}
LOGLEVEL_ROOT=${LOG_LEVEL_ROOT:-OFF}

export LOG_LEVEL=$LOGLEVEL
export LOG_LEVEL_ROOT=$LOGLEVEL_ROOT

echo "logger.rootLogger.level = ${LOGLEVEL_ROOT}">>$F
echo "logging.level.org.springframework = ${LOGLEVEL_ROOT}">>$F
echo "logging.level.de.mgeo = ${LOGLEVEL}">>$F
