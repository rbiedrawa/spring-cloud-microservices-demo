package com.rbiedrawa.cloud.microservices.hello.web.hello;

import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbiedrawa.cloud.microservices.hello.api.users.UserService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("hello")
@AllArgsConstructor
public class HelloController {

	private final UserService userService;

	@GetMapping
	Flux<HelloMessage> sayHelloToAll() {
		return HystrixCommands.from(userService.findAll().map(HelloMessage::from))
							  .commandName("sayHelloToAll")
							  .fallback(Flux.just(HelloMessage.from("Hello from Fallback!")))
							  .toFlux();
	}

	@GetMapping("{userId}")
	Mono<HelloMessage> sayHello(@PathVariable Long userId) {
		return userService.findOne(userId).map(HelloMessage::from);
	}
}
