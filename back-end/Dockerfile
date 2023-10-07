FROM openjdk:17-jdk-slim-buster

RUN apt-get update && apt-get install -y iproute2

VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
