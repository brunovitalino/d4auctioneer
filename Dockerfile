FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /buildfiles
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
RUN ["mvn", "clean", "package", "-Dmaven.test.skip"]

FROM eclipse-temurin:21-jre
WORKDIR /app
ARG JAR_FILE=/buildfiles/target/*jar
COPY --from=build ${JAR_FILE} d4auctioneer-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=default", "-jar", "d4auctioneer-api.jar"]
