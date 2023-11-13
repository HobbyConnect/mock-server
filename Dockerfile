FROM openjdk:17-jdk-alpine
MAINTAINER hobby-connect.de


COPY build/libs/mock-server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar" ]





