image = graphql-poc
appname := $(shell basename $(PWD))

.PHONY: docker update push build publish clean refresh

docker: build
	docker build -t $(image) .

update:
	docker build --pull -t $(image) .

push:
	docker push $(image)

shell:
	docker-compose exec $(appname) /bin/sh 

logs:
	docker-compose logs $(appname)

build:
	./gradlew build

publish:
	./gradlew artifactoryPublish

clean:
	./gradlew clean

refresh:
	./gradlew build --refresh-dependencies

test:
	./gradlew test	

buildOnly:
	./gradlew build -x test
