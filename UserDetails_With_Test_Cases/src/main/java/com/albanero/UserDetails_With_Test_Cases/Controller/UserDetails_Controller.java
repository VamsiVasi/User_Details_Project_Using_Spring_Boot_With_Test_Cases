package com.albanero.UserDetails_With_Test_Cases.Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.albanero.UserDetails_With_Test_Cases.Model.Response_Model;
import com.albanero.UserDetails_With_Test_Cases.Model.User_Model;
import com.albanero.UserDetails_With_Test_Cases.Service.UserDetails_Service;

@RestController
public class UserDetails_Controller {

	@Autowired
	public UserDetails_Service us;

	@GetMapping(value = "/getallusers")
	public List<User_Model> findAllUsers() {
		return us.getAllUsers();
	}

	@GetMapping(value = "/getuserbyname/{username}")
	public List<User_Model> findUserByUsername(@PathVariable String username) {

		return us.getUserByUsername(username);

	}

	@GetMapping(value = "/getuser/cv/cs/{username}")
	public Response_Model getUsers(@PathVariable String username) {
		us.getUserByUsername(username);
		int cv1 = 0, cs1 = 0;
		Pattern p = Pattern.compile("[aeiouAEIOU]");
		Matcher m = p.matcher(username);
		while (m.find()) {
			cv1++;
		}
		Pattern p1 = Pattern.compile("[ !\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]");
		Matcher m1 = p1.matcher(username);
		while (m1.find()) {
			cs1++;
		}
		return new Response_Model(username + " has " + cv1 + " Vowels", username + " has " + cs1 + " Special Characters.");
	}

	@PostMapping(value = "/createuser")
	public String addUser(@RequestBody User_Model u) {
		us.saveUser(u);
		return u.getUsername() + " Details are successfully added.";
	}

	@PutMapping(value = "/updateuser/{username}")
	public String updateByUser(@PathVariable String username, @RequestBody User_Model u) {
		us.updateUser(username, u);
		us.getUserByUsername(username);
		return u.getUsername() + "'s full name was Updated as " + u.getFullname();
	}

	@DeleteMapping(value = "/deleteuser/{username}")
	public String deleteByUser(@PathVariable String username) {
		us.deleteUser(username);
		return username+" was removed";
	}
}
