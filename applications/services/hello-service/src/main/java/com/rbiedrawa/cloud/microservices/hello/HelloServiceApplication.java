package com.rbiedrawa.cloud.microservices.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class HelloServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}

}
