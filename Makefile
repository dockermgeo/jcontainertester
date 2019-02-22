dci=dockermgeo/jcontester

install: java.build

jcb: java.build java.run
java.build:
	mvn clean install

java.run:
	java -jar target/jcontester-0.0.3.jar

build: docker.build docker.run
docker.build: java.build
	bash pre_build.sh
	docker build -t $(dci) .

docker.run:
	docker run -ti --rm -p 8080:8080 $(dci)

docker.test: 
	docker run -ti --rm -p 8080:8080 -e LOG_LEVEL=info -e LOG_LEVEL_ROOT=off $(dci)
