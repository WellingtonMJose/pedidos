FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
WORKDIR /app
COPY --from=build /app/target/pedidos.jar ./pedidos.jar

CMD ["java", "-jar", "pedidos.jar"]
