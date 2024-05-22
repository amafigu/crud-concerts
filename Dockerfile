# Use a base image with JDK 17
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file built by Spring Boot into the Docker image
COPY target/tierrayaire-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]