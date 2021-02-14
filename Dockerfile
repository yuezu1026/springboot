FROM openjdk:8u191-jdk-alpine3.9
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
#EXPOSE 8040 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]