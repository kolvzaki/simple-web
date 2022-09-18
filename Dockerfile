FROM openjdk:18
ADD simple-web-1.0.0-plain.jar /simple-web-1.0.0.jar
RUN bash -c 'touch /simple-web-0.0.1.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/simple-web-1.0.0.jar","--spring.profiles.active=prod"]
MAINTAINER kolvzaki