package com.clearavenue.fdadi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class FdadiUserServiceApplication {

    // TODO: change to use '@Autowired' instead of '@RequiredArgsConstructor+private final'
    private final BuildProperties buildProperties;

    @Bean
    public ApplicationRunner osLogger(final Environment environment) {
        return arguments -> {
            log.info("Starting {} : {}", buildProperties.getName(), buildProperties.getVersion());
            log.info("Running on {} {} ({})", environment.getProperty("os.name"), environment.getProperty("os.version"), environment.getProperty("os.arch"));
            log.info("Startup complete.");
        };
    }

    public static void main(final String[] args) {
        SpringApplication.run(FdadiUserServiceApplication.class, args);
    }
}
