package com.stark.user_details.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stark.user_details.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUsername(String username);

}