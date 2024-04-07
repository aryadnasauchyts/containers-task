FROM registry.access.redhat.com/ubi9/ubi-minimal:9.0.0 AS build

ENV JAVA_HOME=/opt/java/openjdk
COPY --from=eclipse-temurin:21-jre $JAVA_HOME $JAVA_HOME
ENV PATH="${JAVA_HOME}/bin:${PATH}"

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

RUN ./mvnw clean package


FROM registry.access.redhat.com/ubi9/ubi-minimal:9.0.0

ENV JAVA_HOME=/opt/java/openjdk
COPY --from=eclipse-temurin:21-jre $JAVA_HOME $JAVA_HOME
ENV PATH="${JAVA_HOME}/bin:${PATH}"

COPY --from=build /app/target/*.jar /app.jar

USER 1000:1000
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]