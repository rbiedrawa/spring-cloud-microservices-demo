package com.rbiedrawa.cloud.microservices.hello.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCircuitBreaker
public class CircuitBreakerConfiguration {
}
