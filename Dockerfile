FROM openjdk:15-jdk-alpine
VOLUME /tmp
COPY target/*.jar reit.jar
ENTRYPOINT ["java","-jar","/reit.jar"]