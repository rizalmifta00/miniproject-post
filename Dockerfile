FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/bank-*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]