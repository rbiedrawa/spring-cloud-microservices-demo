package com.rbiedrawa.cloud.microservices.gateway.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCircuitBreaker
@Configuration
public class RouteConfiguration {

	@Bean
	RouteLocator customRouteLocator (RouteLocatorBuilder builder) {
		return builder.routes()
					  .route("hello-service", r -> r.path("/api/v1/hello/**")
													.filters(f -> f.stripPrefix(2))
													.uri("lb://hello-service"))
					  .route("user-service", r -> r.path("/api/v1/users/**")
													.filters(f -> f.stripPrefix(2))
													.uri("lb://user-service"))
					  .route("service-behind-hystrix",r -> r.path("/api/v1/hystrix/**")
										  .filters(f -> f.stripPrefix(3)
														 .hystrix(config -> config.setFallbackUri("forward:/your-fallback-uri")))
										  .uri("lb://hello-service"))
					  .build();
	}
}
