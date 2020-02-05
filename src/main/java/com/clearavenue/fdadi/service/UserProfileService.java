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

	private final UserProfileRepository userRepo;

	public Optional<UserProfile> getUser(final String username) {
		final Optional<UserProfile> user = userRepo.findByUserId(username);
		return user;
	}

	public UserProfile saveUser(final UserProfile user) {
		final Optional<UserProfile> existingUser = userRepo.findByUserId(user.getUserId());
		if (existingUser.isPresent()) {
			return existingUser.get();
		}
		return userRepo.save(user);
	}

	public List<UserProfile> getAllUsers() {
		return userRepo.findAll();
	}

	public void deleteAll() {
		userRepo.deleteAll();
	}
}
