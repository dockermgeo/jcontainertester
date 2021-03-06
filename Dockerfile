FROM java as builder

ENV LOGLEVEL_APP=debug

ADD docker_root /

COPY target/jcontester-0.0.8.jar /app.jar

WORKDIR /

EXPOSE 8080

ENTRYPOINT [ "/javastarter.sh"]


FROM builder
