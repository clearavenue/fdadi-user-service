package com.clearavenue.fdadi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clearavenue.fdadi.model.GetUserResult;
import com.clearavenue.fdadi.model.UserProfile;
import com.clearavenue.fdadi.service.UserProfileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserRestController {

	@Autowired
	UserProfileService service;

	@GetMapping("/user/{username}")
	public GetUserResult getUser(@PathVariable final String username) {
		log.info("user-service - getUser {}", username);
		final Optional<UserProfile> user = service.getUser(username);
		return GetUserResult.builder().user(user).build();
	}

	@PostMapping("/saveUser")
	public UserProfile saveUser(@RequestBody final UserProfile user) {
		log.info("user-service - save {}", user);
		final UserProfile saved = service.saveUser(user);
		return saved;
	}

	@GetMapping("/deleteAll")
	public String deleteAll() {
		log.info("user-service - deleteAll");
		service.deleteAll();
		return "All users deleted";
	}
}
