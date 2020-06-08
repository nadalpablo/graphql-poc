FROM openjdk:8-jre-alpine
WORKDIR /app

ENV DEBUG "false"

COPY docker-entrypoint.sh /
COPY ./build/libs/graphql-poc-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["/docker-entrypoint.sh"]
