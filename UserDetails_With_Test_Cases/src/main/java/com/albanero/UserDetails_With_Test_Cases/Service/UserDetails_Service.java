package com.albanero.UserDetails_With_Test_Cases.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albanero.UserDetails_With_Test_Cases.Model.User_Model;
import com.albanero.UserDetails_With_Test_Cases.Repository.UserDetails_Repository;

@Service
public class UserDetails_Service {

	@Autowired
	private UserDetails_Repository ur;

	public List<User_Model> getAllUsers() {
		return ur.findAll();
	}

	public List<User_Model> getUserByUsername(String username) {
		return ur.findUserByUsername(username);
	}
	
	public User_Model saveUser(User_Model u) {
		return ur.save(u);
	}

	public User_Model updateUser(String username, User_Model u) {
		return ur.save(u);
	}

	public void deleteUser(String username) {
		ur.delete(ur.findUserByUsername(username).get(0));
	}
}
