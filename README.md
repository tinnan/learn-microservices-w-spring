# learn-microservice-w-spring
Learn building microservices with Spring boot and Spring cloud.<br>
Guide: [Amigoscode - Microservices Using Spring Boot and Spring Cloud](https://youtu.be/p485kUNpPvE?si=hGl1ZznhoP154gQg)

## Pre-requisite for building project
The project uses ```jib-maven-plugin``` to containerize app and upload to local Docker daemon.
1. Have Docker running and ```docker``` CLI available in PATH.
2. Install and configure [docker-credential-helper](https://github.com/docker/docker-credential-helper). After 
   configure, 
   recommend 
   running command ```docker logout``` and ```docker login```. Also, if Maven complains about missing URL e.g. 
   registry-1.docker.io, you should run ```docker login <the missing URL>```.

## Build
Run ```./mvnw -P build-docker-image package``` in project root directory.
