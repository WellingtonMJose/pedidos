FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY pedidos.jar /opt/app
CMD ["java", "-jar", "/opt/app/pedidos.jar"]
