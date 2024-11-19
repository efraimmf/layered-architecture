FROM openjdk:17-jdk-slim

WORKDIR /app

RUN apt-get update && apt-get install -y maven

COPY . .

EXPOSE 8081

CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.fork=false"]
