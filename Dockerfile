FROM eclipse-temurin:21
COPY build/libs/cnm-core-model.war app.war
ENTRYPOINT ["java","-jar","/app.war"]