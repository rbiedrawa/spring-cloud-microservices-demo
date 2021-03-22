# Config Server

Spring Boot application that provides server-side and client-side support for externalized configuration in a distributed system.

With the Config Server, you have a central place to manage external properties for applications across all environments.

## Getting Started

### Installation

Start application:

```
./gradlew bootRun
```

### Usage

* Start service.

* Open ['api-gateway' configuration](http://localhost:8888/api-gateway/dev).

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
| `Config Server` | http://localhost:8888/ |
| `Service configuration for specific env` | `http://localhost:8888/<SERVICE_NAME>/<PROFILE>` |
