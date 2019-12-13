package com.clearavenue.fdadi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearavenue.fdadi.model.UserProfile;
import com.clearavenue.fdadi.repository.UserProfileRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserProfileService {

	@Autowired
	UserProfileRepository userRepo;

	public Optional<UserProfile> getUser(final String username) {
		final Optional<UserProfile> user = userRepo.findByUserId(username);
		log.info("getUser({}) returned: {}", username, user.toString());
		return user;
	}

	public UserProfile saveUser(final UserProfile user) {
		return userRepo.save(user);
	}

	public void deleteAll() {
		userRepo.deleteAll();
	}

}
