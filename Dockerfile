FROM eclipse-temurin:17-jdk-focal
VOLUME /tmp
ARG JAR_FILE
COPY ./build/libs/EshopProject-0.0.1-SNAPSHOT.jar Eshopproject_Backend.jar
ENTRYPOINT ["java","-jar","/Eshopproject_Backend.jar"]