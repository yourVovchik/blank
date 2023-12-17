FROM openjdk:17.0.2-jdk-slim-buster
ADD target/*.jar aop.jar
ENTRYPOINT ["java","-jar","/aop.jar"]

