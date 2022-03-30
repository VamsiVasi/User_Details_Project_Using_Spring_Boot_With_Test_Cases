package com.stark.user_details.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stark.user_details.DTO.UserDTO;
import com.stark.user_details.entity.User;
import com.stark.user_details.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public String createUser(UserDTO userDTO) {
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setFullname(userDTO.getFullname());
		user.setAddress(userDTO.getAddress());
		user.setCompany(userDTO.getCompany());
		user.setEmail(userDTO.getEmail());
		user.setMobile(userDTO.getMobile());
		userRepo.save(user);
		return userDTO.getUsername() + " Details were successfully added.";
	}

	public String updateUserByUsername(String username, UserDTO userDTO) {
		User user = userRepo.findByUsername(username);
		user.setUsername(userDTO.getUsername());
		user.setFullname(userDTO.getFullname());
		user.setAddress(userDTO.getAddress());
		user.setCompany(userDTO.getCompany());
		user.setEmail(userDTO.getEmail());
		user.setMobile(userDTO.getMobile());
		userRepo.save(user);
		return userDTO.getUsername() + " Details were successfully updated.";
	}

	public String deleteUserByUsername(String username) {
		userRepo.delete(userRepo.findByUsername(username));
		return username + " Details were successfully removed";
	}
}
