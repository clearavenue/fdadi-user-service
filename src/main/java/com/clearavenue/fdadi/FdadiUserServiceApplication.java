package com.clearavenue.fdadi;

import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class FdadiUserServiceApplication {

	private final BuildProperties buildProperties;

	@Bean
	public ApplicationRunner osLogger(Environment environment) {
		return (arguments) -> {
			log.info("Starting {} : {}", buildProperties.getName(), buildProperties.getVersion());
			log.info("Running on {} {} ({})", environment.getProperty("os.name"), environment.getProperty("os.version"), environment.getProperty("os.arch"));
                        log.info("Startup complete.");
		};
	}

	public static void main(final String[] args) {
		SpringApplication.run(FdadiUserServiceApplication.class, args);
	}
}
