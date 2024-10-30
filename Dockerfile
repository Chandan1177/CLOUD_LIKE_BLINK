# Dockerfile for Spring Boot App

# Use OpenJDK 17 (or your desired version) as the base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the jar file to the container
COPY target/*.jar app.jar

# Expose the port that the Spring Boot application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
