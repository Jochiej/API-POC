FROM openjdk:16-jdk
MAINTAINER "Jochem Leunisse"
EXPOSE 8080
COPY target/FHICT-0.0.1-SNAPSHOT.jar FHICT-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]