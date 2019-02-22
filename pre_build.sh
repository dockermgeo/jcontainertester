#!/usr/bin/env bash


FV=docker_root/version
echo $(($(cat ${FV}) +1))>${FV}



URL_BOOTSTRAP_CSS="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
RSRC=src/main/resources
curl -k "${URL_BOOTSTRAP_CSS}" -o ${RSRC}/static/bootstrap.css
