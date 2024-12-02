# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host to the container
COPY build/libs/*.jar app.jar

# Copy the application.properties file
COPY src/main/resources/application.properties /app/application.properties

# Expose the port that the application will run on
EXPOSE 8080

# Add a command to list files in the working directory for debugging
RUN ls -l /app

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]