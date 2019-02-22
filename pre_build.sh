#!/usr/bin/env bash

FV=docker_root/version
echo $(($(cat ${FV}) +1))>${FV}
