FROM openjdk:17-jdk

LABEL maintainer="ayushkoli772@gmail.com"

EXPOSE 8080

WORKDIR /app

COPY ./target/crud-spring-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "crud-spring-0.0.1-SNAPSHOT.jar"]