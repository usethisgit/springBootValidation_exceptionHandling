#non-multi stage Dockerfile
#---------------------------
#FROM openjdk:17-jdk-slim
#copy target/spring_bean_validation_ExceptionHandling_example.jar spring_bean_validation_ExceptionHandling_example.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "spring_bean_validation_ExceptionHandling_example.jar"]

# Multi-stage Dockerfile for building and running a Spring Boot application
# ---------------------------
# Stage 1: Build the JAR file
# ---------------------------
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Copy pom.xml and download dependencies first (cache friendly)
COPY pom.xml .
RUN mvn dependency:go-offline -B
# Copy the rest of the source code
COPY src ./src
# Build the jar file (skip tests for faster builds in CI/CD)
RUN mvn clean package -DskipTests

# ---------------------------
# Stage 2: Run the Application
# ---------------------------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copy only the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Optional: document exposed port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]