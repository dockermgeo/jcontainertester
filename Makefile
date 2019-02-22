dci=dockermgeo/jenvsecrets

install: java.build

jcb: java.build java.run
java.build:
	mvn clean install

java.run:
	java -jar target/jenvsecrets-0.0.1.jar

build: docker.build docker.run
docker.build: java.build
	docker build -t $(dci) .

docker.run:
	docker run -ti --rm -p 8080:8080 $(dci)

docker.test: 
	docker run -ti --rm -p 8080:8080 -e LOG_LEVEL=trace -e LOG_LEVEL_ROOT=trace $(dci)
