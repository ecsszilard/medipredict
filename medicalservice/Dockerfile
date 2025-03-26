FROM openjdk:21-jdk-slim
LABEL authors="Szilard"
WORKDIR /app
COPY target/medicalservice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
