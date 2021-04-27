package com.clearavenue.fdadi.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clearavenue.fdadi.model.UserProfile;
import com.clearavenue.fdadi.model.UserResult;
import com.clearavenue.fdadi.service.UserProfileService;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    private final UserProfileService service;

    @SuppressFBWarnings(value = "SPRING_ENDPOINT", justification = "This is a valid spring endpoint")
    @GetMapping("/user/{username}")
    public UserResult getUser(@PathVariable final String username) {
        log.debug("user-service - getUser {}", username);
        log.debug("all-users = ");
        log.debug("{}", service.getAllUsers());
        log.debug("done all-users");
        final Optional<UserProfile> user = service.getUser(username);
        return UserResult.builder().user(user).build();
    }

    @SuppressFBWarnings(value = { "SPRING_ENDPOINT", "ENTITY_MASS_ASSIGNMENT" }, justification = "This is a valid spring endpoint, user object saved in service")
    @PostMapping("/saveUser")
    public UserResult saveUser(@Valid @RequestBody final UserProfile user) {
        log.debug("user-service - save {}", user);

        final UserProfile saved = service.saveUser(user);
        return UserResult.builder().user(Optional.of(saved)).build();
    }

    @SuppressFBWarnings(value = "SPRING_ENDPOINT", justification = "This is a valid spring endpoint")
    @GetMapping("/deleteAll")
    public String deleteAll() {
        log.debug("user-service - deleteAll");
        service.deleteAll();
        return "All users deleted";
    }
}
