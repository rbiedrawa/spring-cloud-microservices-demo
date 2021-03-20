package com.rbiedrawa.cloud.microservices.admin.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class AdminDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminDashboardApplication.class, args);
	}

}
