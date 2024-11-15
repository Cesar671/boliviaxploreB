FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY target/boliviaXplore-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]

