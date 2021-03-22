# User Service

This microservice provides the user functionality exposed by REST endpoints.

Application supports distributed tracing(Spring Cloud Sleuth, Zipkin) and OpenAPI Specification standard.

## Getting Started

### Prerequisite

* Running [config-server](../../config-server).
* Running [service-registry](../../service-registry).
* Running [zipkin](../../..) server.
* Running [admin-dashboard](../../admin-dashboard).

### Installation

Start application:

```
./gradlew bootRun
```

### Usage

* Start service.

* Open 'user-service'[OpenAPI ui](http://localhost:8081/swagger-ui.html).

* Fetch users

* Check if application successfully registered in [service-registry](http://localhost:8761/)

* Check if application is visible in [admin-dashboard](http://localhost:8085/applications).

### Build

```
# Clean build jar
./gradlew clean build

# Build docker image
./gradlew jibDockerBuild
```

## Important Endpoints

| Name | Endpoint | 
| -------------:|:--------:|
| `User Service` | http://localhost:8081/ |
| `Swagger UI` | http://localhost:8081/swagger-ui.html |
| `Swagger api-docs` | http://localhost:8081/v3/api-docs |
