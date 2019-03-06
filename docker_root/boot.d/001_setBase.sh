#!/usr/bin/env bash

F=/application.properties
HTML_TITLE=${HTML_TITLE:-"jConDemo - Workshop"}


echo "# Autogen by Docker.boot">$F
echo "spring.thymeleaf.cache=false" >>$F
echo "html.title=${HTML_TITLE}" >>$F
