package com.rbiedrawa.cloud.microservices.hello.web.hello;

import com.rbiedrawa.cloud.microservices.hello.api.users.User;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HelloMessage {

	private static final String GREET_USER_MSG = "Hello, %s %s!";

	private final String value;

	private HelloMessage(String value) {
		this.value = value;
	}

	public static HelloMessage from(User user) {
		return new HelloMessage(String.format(GREET_USER_MSG, user.getFirstName(), user.getLastName()));
	}

	public static HelloMessage from(String value) {
		return new HelloMessage(value);
	}

}
