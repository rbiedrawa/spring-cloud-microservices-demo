package com.rbiedrawa.cloud.microservices.hello;

import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("hello")
@AllArgsConstructor
public class HelloController {


	@GetMapping
	Flux<String> hello() {
		return HystrixCommands.from(fetchMessages())
							  .fallback(Flux.empty())
							  .commandName("hello")
							  .toFlux();
	}

	private Flux<String> fetchMessages() {
		return Flux.just("test1", "test2", "test3");
	}

}
