FROM java

ENV LOG_LEVEL=error

ADD docker_root /


COPY target/jcontester-0.0.3.jar /app.jar

WORKDIR /
ENTRYPOINT [ "/javastarter.sh"]
