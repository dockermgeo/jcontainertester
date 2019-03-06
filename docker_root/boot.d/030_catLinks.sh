#!/usr/bin/env bash

S=/links.properties
T=/application.properties

echo "# LINKS" >> ${T}
cat ${S} >> ${T}

