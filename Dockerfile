FROM openjdk:8-alpine
WORKDIR /col
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY target/collection-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java","-jar","./app.jar"]