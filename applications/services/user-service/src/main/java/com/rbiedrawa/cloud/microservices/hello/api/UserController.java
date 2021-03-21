package com.rbiedrawa.cloud.microservices.hello.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping Flux<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("{userId}") Mono<User> findOne(@PathVariable Long userId) {
		log.info("Searching for user {} ...", userId);
		return userService.findByUserId(userId);
	}

}
