package com.clearavenue.fdadi.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clearavenue.fdadi.model.UserProfile;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, ObjectId> {

	Optional<UserProfile> findByUserId(String userId);
}
