package com.albanero.UserDetails_With_Test_Cases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.albanero.UserDetails_With_Test_Cases.Model.User_Model;
import com.albanero.UserDetails_With_Test_Cases.Repository.UserDetails_Repository;
import com.albanero.UserDetails_With_Test_Cases.Service.UserDetails_Service;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsWithTestCasesApplicationTests {

	@Autowired
	private UserDetails_Service us;

	@MockBean
	private UserDetails_Repository ur;

	@Test
	public void getAllUsersTest() {
		when(ur.findAll()).thenReturn(Stream
				.of(new User_Model(31276, "Balu453", "Balu Prakash", "balu73@gmail.com", "Guntur", 987453121, "Albanero"),
						new User_Model(95128, "Venky112", "Venkatesh", "venky8564@gmail.com", "VSP", 897456312, "Albanero"))
				.collect(Collectors.toList()));
		assertEquals(2, us.getAllUsers().size());
	}

	@Test
	public void getUserByUsernameTest() {
		String username = "Balu453";
		when(ur.findUserByUsername(username)).thenReturn(
				Stream.of(new User_Model(31276, "Balu453", "Balu Prakash", "balu73@gmail.com", "Guntur", 987453121, "YSL"))
						.collect(Collectors.toList()));
		assertEquals(1, us.getUserByUsername(username).size());
	}

	@Test
	public void saveUserTest() {
		User_Model u = new User_Model(292798, "SK2729", "Skrishna", "skrishna2904@mail.com", "Delhi", 982368346, "AIIMS");
		when(ur.save(u)).thenReturn(u);
		assertEquals(u, us.saveUser(u));
	}

	@Test
	public void updateUserByUsernameTest() {
		String username = "SK2729";
		User_Model u = new User_Model(292798, "SK2729", "Skr@shn*", "skrishna2904@mail.com", "Delhi", 982368346, "AIIMS");
		when(ur.findUserByUsername(username)).thenReturn(Stream.of(u).collect(Collectors.toList()));
		assertEquals(1, us.getUserByUsername(username).size());
		when(ur.save(u)).thenReturn(u);
		assertEquals(u, us.updateUser(username, u));
	}

	@Test
	public void deleteUserByUsernameTest() {
		String username = "Balu453";
		User_Model u = new User_Model(31276, "Balu453", "Balu Prakash", "balu73@gmail.com", "Guntur", 987453121, "YSL");
		when(ur.findUserByUsername(username)).thenReturn(Stream.of(u).collect(Collectors.toList()));
		assertEquals(1, us.getUserByUsername(username).size());
		us.deleteUser(username);
		verify(ur, times(1)).delete(u);
	}

}
