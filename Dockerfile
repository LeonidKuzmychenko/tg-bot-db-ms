FROM openjdk:11
MAINTAINER Leonid
COPY target/db-0.1.jar app.jar
EXPOSE 1010
ENTRYPOINT ["java", "-jar", "/app.jar"]
