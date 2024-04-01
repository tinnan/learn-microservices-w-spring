# learn-microservice-w-spring
Learn building microservices with Spring boot and Spring cloud.<br>
Guide: [Amigoscode - Microservices Using Spring Boot and Spring Cloud](https://youtu.be/p485kUNpPvE?si=hGl1ZznhoP154gQg)

# Table of contents

## Pre-requisite for building project
The project uses `jib-maven-plugin` to containerize app and upload to Docker registry.
1. Have Docker running and `docker` CLI available in PATH.
2. Install and configure [docker-credential-helper](https://github.com/docker/docker-credential-helper). After 
   configure, 
   recommend 
   running command `docker logout` and `docker login`. Also, if Maven complains about missing URL e.g. 
   registry-1.docker.io, you should run `docker login <the missing URL>`.

## Build
Run `./mvnw -P build-docker-image package` in project root directory.

## 1. Run project with Docker compose
Run `docker compose --profile dev up -d` to only spin up containers for PostgreSQL, MongoDB, RabbitMQ, Zipkin, PgAdmin \
Run `docker compose --profile integrate up -d` to start every service in container.

## 2. Run project with Minikube
### 2.1 Pre-requisite
- Install Minikube on your machine with a container driver. (I installed Minikube on Windows 10 machine with 
Docker as driver)
- Install kubectl CLI tool.
- Make sure to build the project to upload service image to Docker registry.
### 2.2 Deploy Kubernetes objects
Run `kubectl apply -Rf ./k8s-minikube`
### 2.3 Start service tunnel
This step may vary between host system/OS. My system (Windows 10) somehow does not allow connecting directly to 
`minikube ip` (Not sure if there is anyway to fix this). \
To start using to deployed service, start service tunnel by: \
First, list services by `minikube service list` \
Next, Run command `minikube service <service name>`. Minikube will create a port on localhost to tunnel to service 
inside the cluster.

### Try
__*The port numbers shown below are default configuration. If you deploy to Minikube and use service tunnel, please 
update the port number accordingly.*__ \
pgadmin: http://localhost:5050 - Password `password` \
Eureka dashboard: http://localhost:8761 \
RabbiMQ dashboard: http://localhost:15672 - User `guest` Password `guest` \
Zipkin: http://localhost:9411 \
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
GET http://localhost:8081/api/v1/fraud-check/:customerId
```
Notification API:
```
GET http://localhost:8082/api/v1/notification/info
```