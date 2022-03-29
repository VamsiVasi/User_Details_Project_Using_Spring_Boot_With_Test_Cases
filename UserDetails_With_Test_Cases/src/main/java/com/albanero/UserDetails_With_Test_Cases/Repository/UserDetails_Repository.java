package com.albanero.UserDetails_With_Test_Cases.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.albanero.UserDetails_With_Test_Cases.Model.User_Model;

@Repository
public interface UserDetails_Repository extends MongoRepository<User_Model, Integer> {

	List<User_Model> findUserByUsername(String username);

}