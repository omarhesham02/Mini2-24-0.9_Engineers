FROM openjdk:23-jdk-slim

WORKDIR /app

COPY ./target/mini2.jar /app/target/mini2.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/target/mini2.jar"]