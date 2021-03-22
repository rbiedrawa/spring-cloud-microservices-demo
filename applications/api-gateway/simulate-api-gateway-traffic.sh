# Simulate small traffic for spring-boot-admin hystrix view

for i in {1..30} ; do
    curl "http://localhost:8082/api/v1/hello" &
    curl "http://localhost:8082/api/v1/hystrix/hello" &
    curl "http://localhost:8082/api/v1/users/" &
    curl "http://localhost:8082/api/v1/hello/hystrix?shouldFail=true" &
    curl "http://localhost:8082/api/v1/hello/hystrix?shouldFail=false"
done
