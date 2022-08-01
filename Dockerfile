FROM openjdk:11.0-jdk as build-image

MAINTAINER Pedro Barreto e Caique Quaresma

EXPOSE 8088
WORKDIR /app

COPY target/droneFeeder-0.0.1-SNAPSHOT.jar .

ENTRYPOINT [ "java", "-jar", "./droneFeeder-0.0.1-SNAPSHOT.jar" ]