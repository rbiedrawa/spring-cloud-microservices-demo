# Admin Dashboard

Admin Dashboard is Spring Boot Admin application that provides a monitoring interface for Spring Boot applications.

Additionally, application adds custom [Hystrix Dashboard](https://github.com/Netflix-Skunkworks/hystrix-dashboard/) view module.

## Getting Started

### Prerequisite

* Running [config-server](../config-server).
* Running [service-registry](../service-registry).

### Installation

Start application:

```
./gradlew bootRun
```

### Usage

* Start service.

* Open [admin dashboard](http://localhost:8085).


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
| `Admin Dashboard` | http://localhost:8085 |

## References

* [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin)
* [Hystrix Dashboard for Spring Boot Admin 2.x](https://github.com/MartinDevillers/spring-boot-admin-hystrix-dashboard)
* [Hystrix Dashboard](https://github.com/Netflix-Skunkworks/hystrix-dashboard/)