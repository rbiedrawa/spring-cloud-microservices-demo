package com.rbiedrawa.cloud.microservices.hello.web;

import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class HystrixController {

	@GetMapping("hystrix")
	Flux<String> hystrix(@RequestParam(defaultValue = "false", name = "shouldFail") boolean shouldFail) {
		return HystrixCommands.from(fetchMessages(shouldFail))
							  .fallback(Flux.empty())
							  .commandName("hystrix")
							  .toFlux();
	}

	private Flux<String> fetchMessages(boolean shouldFail) {
		if(shouldFail) {
			return Flux.error(new RuntimeException("Simulated Error!!!"));
		}
		return Flux.just("test1", "test2", "test3");
	}
}
