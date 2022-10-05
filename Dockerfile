FROM openjdk:11
ADD target/*.jar it-api-log
ENTRYPOINT ["java", "-jar","it-api-log"]
EXPOSE 8080