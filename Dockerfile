# Stage 1: Build stage
FROM openjdk:11 as build

WORKDIR /app

COPY . /app

# Install JDK and other build tools
RUN apt-get update && apt-get install -y openjdk-11-jdk && \
    javac SingleReverseLL.java

# Stage 2: Final stage
FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /app /app

ENTRYPOINT ["java", "-cp", ".", "SingleReverseLL"]

# You may need to adjust the CMD based on your application requirements
CMD ["java", "-cp", ".", "SingleReverseLL"]

