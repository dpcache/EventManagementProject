FROM eclipse-temurin:17-jdk-alpine

COPY ./build/libs/EventManagementProject.jar EventManagementProject.jar

ENTRYPOINT ["java", "-jar", "EventManagementProject.jar"]

