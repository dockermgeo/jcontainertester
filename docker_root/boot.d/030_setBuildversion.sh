#!/usr/bin/env bash

F=/application.properties

echo "# VERSION" >>$F
echo "app.version=$(cat /version)">>$F
