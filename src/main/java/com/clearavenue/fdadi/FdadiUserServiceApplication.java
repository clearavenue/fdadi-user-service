package com.clearavenue.fdadi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FdadiUserServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(FdadiUserServiceApplication.class, args);
	}

}
