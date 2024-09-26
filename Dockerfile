FROM maven:3.8.6-openjdk-21 AS build
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
COPY --from=build /app/target/pedidos.jar ./pedidos.jar

CMD ["java", "-jar", "pedidos.jar"]
