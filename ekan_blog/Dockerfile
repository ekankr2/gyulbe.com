FROM openjdk:17-alpine

RUN apk update

ARG JAR_FILE=build/libs/ekan_blog-*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
