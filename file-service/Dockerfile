FROM java:8u111
VOLUME /temp
COPY target/file-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8901
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]