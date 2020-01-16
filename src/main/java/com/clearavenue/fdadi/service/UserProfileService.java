package com.clearavenue.fdadi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clearavenue.fdadi.model.UserProfile;
import com.clearavenue.fdadi.repository.UserProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserProfileService {

	final String ip = "10.0.0.1";

	private final UserProfileRepository userRepo;

	public Optional<UserProfile> getUser(final String username) {
		final Optional<UserProfile> user = userRepo.findByUserId(username);
		return user;
	}

	public UserProfile saveUser(final UserProfile user) {
		return userRepo.save(user);
	}

	public List<UserProfile> getAllUsers() {
		return userRepo.findAll();
	}

	public void deleteAll() {
		userRepo.deleteAll();
	}
}
