FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17.0-jdk-slim

WORKDIR /app

COPY  --from=build /app/target/DigitalLibraryBookManagement-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

ENTRYPOINT [ "java", "-jar", "/app/DigitalLibraryBookManagement-0.0.1-SNAPSHOT.jar" ]