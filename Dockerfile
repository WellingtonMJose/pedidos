FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY pedidos.jar /app/target/pedidos.jar ./pedidos.jar/
CMD ["java", "-jar", "pedidos.jar"]
