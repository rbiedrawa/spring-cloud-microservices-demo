package com.rbiedrawa.cloud.microservices.hello.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class UserService {

	private static final Map<Long, User> USERS_DB = new ConcurrentHashMap<>(Map.of(
		1L, new User(1L, "User", "User"),
		2L, new User(2L, "Admin", "Admin")
																				  ));

	public Mono<User> findByUserId(Long id) {
		return Mono.just(USERS_DB.get(id));
	}

	public Flux<User> findAll() {
		return Flux.fromIterable(USERS_DB.values());
	}
}
