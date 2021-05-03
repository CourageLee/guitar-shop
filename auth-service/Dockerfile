FROM java:8u111
VOLUME /temp
ADD target/auth-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
EXPOSE 8801