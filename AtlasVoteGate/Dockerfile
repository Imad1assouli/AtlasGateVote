# Use an official OpenJDK runtime as a parent image
FROM openjdk:11

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file from the host into the container
COPY ./target/AtlasVoteGate-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
CMD ["java", "-jar", "app.jar"]
