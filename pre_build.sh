#!/usr/bin/env bash


echo "Createing Version"
FV=docker_root/version
echo $(($(cat ${FV}) +1))>${FV}

