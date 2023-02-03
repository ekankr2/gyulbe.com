FROM openjdk:17-jdk

RUN apt-get update && apt-get -y install sudo

ARG JAR_FILE=build/libs/ekan_blog-*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]
