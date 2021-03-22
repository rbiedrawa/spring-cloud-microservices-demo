# Hello Service

This microservice provides the 'hello' functionality exposed by REST endpoints.

Application supports distributed tracing(Spring Cloud Sleuth, Zipkin) and OpenAPI Specification standard.

Additionally, application implements 'Circuit Breaker' pattern using Netflix Hystrix library. 

## Getting Started

### Prerequisite

* Running [config-server](../../config-server).
* Running [service-registry](../../service-registry).
* Running [zipkin](./../../../Readme.md) server.
* Running [admin-dashboard](../../admin-dashboard).
* Running [user-service](../user-service).

### Installation

Start application:

```
./gradlew bootRun
```

### Usage

* Start service.

* Open 'hello-service' [OpenAPI ui](http://localhost:8080/swagger-ui.html).

* Check client side load balancing using 'hello-controller'.

* Check if application successfully registered in [service-registry](http://localhost:8761/).
  
* Play with hystrix:)
  ```shell
  # Simulate hystrix failure
  curl "http://localhost:8080/hello/hystrix?shouldFail=true"
  
  # Simulate hystrix success
  curl "http://localhost:8080/hello/hystrix?shouldFail=false"
  
  # Get 'Hello' endpoint is also behind Circut Breaker
  curl "http://localhost:8080/hello"
  ```
* Check Hystrix dashboard:
  * Go to [admin-dashboard](http://localhost:8085/applications).
  * Choose 'hello-service' application.
  * Click Hystrix tab.
  * Simulate traffic in hello-service
  
* Open [zipkin ui](http://localhost:9411/zipkin/) and investigate traces.

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
| `Hello Service` | http://localhost:8080/ |
| `Swagger UI` | http://localhost:8080/swagger-ui.html |
| `Swagger api-docs` | http://localhost:8080/v3/api-docs |
| `Actuator - Hystrix Stream` | http://localhost:8080/actuator/hystrix.stream |

