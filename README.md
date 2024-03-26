# learn-microservice-w-spring
Learn building microservices with Spring boot and Spring cloud.<br>
Guide: [Amigoscode - Microservices Using Spring Boot and Spring Cloud](https://youtu.be/p485kUNpPvE?si=hGl1ZznhoP154gQg)

## Pre-requisite for building project
The project uses `jib-maven-plugin` to containerize app and upload to local Docker daemon.
1. Have Docker running and `docker` CLI available in PATH.
2. Install and configure [docker-credential-helper](https://github.com/docker/docker-credential-helper). After 
   configure, 
   recommend 
   running command `docker logout` and `docker login`. Also, if Maven complains about missing URL e.g. 
   registry-1.docker.io, you should run `docker login <the missing URL>`.

## Build
Run `./mvnw -P build-docker-image package` in project root directory.

## Run
Run `docker compose up -d`

## Try
pgadmin: http://localhost:5050 - Password `password`\
Eureka dashboard: http://localhost:8761\
RabbiMQ dashboard: http://localhost:15672 - User `guest` Password `guest`\
Zipkin: http://localhost:9411\
Customer API:
```
POST http://localhost:8080/api/v1/customers
Body:
{
   "firstName": "John",
   "lastName": "Doe",
   "email": "john.d@gmail.com"
}
```
Fraud API:
```
GET http://localhost:8080/api/v1/fraud-check/:customerId
```
