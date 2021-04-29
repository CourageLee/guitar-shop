FROM java:8u111
VOLUME /temp
ADD target/eureka-server-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
EXPOSE 8761 8762