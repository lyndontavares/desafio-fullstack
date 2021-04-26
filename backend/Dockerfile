FROM openjdk:8-alpine
VOLUME /tmp
EXPOSE 8080
COPY target/springboot-desafio-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-XX:MaxRAMFraction=1","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
#remote debugging
#CMD ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9009","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
#debugging, wait for debugger
#CMD ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=9009","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
