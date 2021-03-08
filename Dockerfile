FROM arm64v8/openjdk:8-alpine
WORKDIR /col
COPY collection-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java","-jar","./app.jar"]