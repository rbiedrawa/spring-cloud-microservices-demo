package com.rbiedrawa.cloud.microservices.hello.api.users;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {
	private static final String USER_SERVICE_LB_BASE_URL = "lb://user-service/users";
	private static final String GET_USER_BY_ID_URL = USER_SERVICE_LB_BASE_URL + "/{userId}";

	private final WebClient.Builder userClient;

	public Flux<User> findAll() {
		return userClient.build().get().uri(USER_SERVICE_LB_BASE_URL)
						 .retrieve().bodyToFlux(User.class);
	}

	public Mono<User> findOne(Long userId) {
		return userClient.build()
						 .get()
						 .uri(GET_USER_BY_ID_URL, userId)
						 .retrieve()
						 .bodyToMono(User.class);

	}
}
