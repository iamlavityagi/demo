# Use the official openjdk image as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /demo

ARG JAR_FILE=target/*.jar

# Copy the jar file into the container
COPY ${JAR_FILE} demo.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/demo/demo.jar"]
