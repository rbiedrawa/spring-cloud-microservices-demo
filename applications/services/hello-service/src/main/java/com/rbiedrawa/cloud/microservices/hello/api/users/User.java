package com.rbiedrawa.cloud.microservices.hello.api.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;
	private String firstName;
	private String lastName;
}
