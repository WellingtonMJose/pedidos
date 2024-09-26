FROM maven:3.9-amazoncorretto-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine
COPY --from=build /target/pedidos-0.0.1-SNAPSHOT.jar ./pedidos-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "pedidos-0.0.1-SNAPSHOT.jar"]
