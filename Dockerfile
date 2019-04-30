FROM openjdk:8-jdk-alpine


ENV SPRING_PATH /usr/local/spring
ENV APP ${SPRING_PATH}/webapps/
RUN mkdir -p ${APP}
COPY . ${APP}
WORKDIR ${APP}
RUN ./mvnw package
ENTRYPOINT java -jar ${APP}/target/api-0.0.1-SNAPSHOT.jar
