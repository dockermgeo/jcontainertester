PROJECT=jcontester
GROUP=dockermgeo
VERSION=0.0.8

install: java.build


#
# JAVA
#
jcb: java.build java.run
java.build:
	mvn clean install

java.run:
	java -jar target/$(PROJECT)-$(VERSION).jar

jcr:
	mvn spring-boot:run


java.release: java.build
	mkdir -p ./release
	rm -f ./release/*
	cp -vf target/$(PROJECT)-$(VERSION).jar release/

#
# DOCKER
#
build: docker.build docker.run
release: java.release docker.build docker.push
docker.build: java.build
	sh pre_build.sh
	docker build -t $(GROUP)/$(PROJECT) -f Dockerfile .

docker.run:
	docker run -ti --rm -p 8080:8080 $(GROUP)/$(PROJECT)

docker.push:
	docker push $(GROUP)/$(PROJECT)

test.env:
	docker run -ti --rm -p 8080:8080 -e LOGLEVEL_APP=debug -e LOG_LEVEL_ROOT=off $(GROUP)/$(PROJECT)

test.configmap:
	docker run -ti --rm -p 8080:8080  -e LOGLEVEL_DOMAIN=debug -e LOG_LEVEL_ROOT=off $(GROUP)/$(PROJECT)

test.secret:
	docker run -ti --rm -p 8080:8080 -e LOG_LEVEL_ROOT=off -v /docker/data/secrets:/secrets $(GROUP)/$(PROJECT)
