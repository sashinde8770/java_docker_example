FROM openjdk:11-jdk-slim

WORKDIR /app

COPY . /app

RUN javac SingleReverseLL.java

CMD ["java", "-cp", ".", "SingleReverseLL"]

