FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY target/pedidos-0.0.1-SNAPSHOT.jar ./pedidos.jar
CMD ["java", "-jar", "pedidos.jar"]
