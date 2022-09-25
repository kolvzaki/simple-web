FROM openjdk:11
ADD ./build/libs/simple-web-1.0.0.jar /simple-web-1.0.0.jar
RUN bash -c 'touch /simple-web-0.0.1.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/simple-web-1.0.0.jar","--spring.profiles.active=prod"]
MAINTAINER kolvzaki