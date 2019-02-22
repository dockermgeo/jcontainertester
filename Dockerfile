FROM java

ENV LOG_LEVEL=error

ADD docker_root /

COPY target/jenvsecrets-0.0.1.jar /app.jar

WORKDIR /
ENTRYPOINT [ "/javastarter.sh"]
