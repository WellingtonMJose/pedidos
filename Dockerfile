FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY pedidos.jar ./pedidos.jar/
CMD ["java", "-jar", "pedidos.jar"]
