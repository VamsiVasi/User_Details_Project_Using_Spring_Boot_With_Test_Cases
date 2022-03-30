package com.stark.user_details;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.stark.user_details.DTO.UserDTO;
import com.stark.user_details.entity.User;
import com.stark.user_details.repository.UserRepository;
import com.stark.user_details.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsTestCasesApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepo;

	@Test
	public void getAllUsersTest() {
		when(userRepo.findAll()).thenReturn(Stream
				.of(new User("Balu453", "Balu Prakash", "balu73@gmail.com", "Guntur", 887453112, "ABC"),
						new User("Venky112", "Venkatesh", "venky8564@gmail.com", "VSP", 782346827, "HGF"))
				.collect(Collectors.toList()));
		assertEquals(2, userService.getAllUsers().size());
	}

	@Test
	public void getUserByUsernameTest() {
		String username = "Balu453";
		User user = new User("Balu453", "Balu Prakash", "balu73@gmail.com", "Guntur", 987453121, "YSL");
		when(userRepo.findByUsername(username)).thenReturn(user);
		assertEquals(user, userService.getUserByUsername(username));
	}

	@Test
	public void createUserTest() {
		UserDTO userDTO = new UserDTO("SK2729", "Skrishna", "skrishna2904@mail.com", "Delhi", 982368347, "AIIMS");
		User user = new User(userDTO.getUsername(), userDTO.getFullname(), userDTO.getEmail(), userDTO.getAddress(),
				userDTO.getMobile(), userDTO.getCompany());
		when(userRepo.save(user)).thenReturn(user);
		assertEquals("SK2729 Details were successfully added.", userService.createUser(userDTO));
	}

	@Test
	public void updateUserByUsernameTest() {
		String username = "SK2729";
		User user = new User("SK2729", "Skrishna", "skrishna2904@mail.com", "Delhi", 982368347, "AIIMS");
		when(userRepo.findByUsername(username)).thenReturn(user);
		assertEquals(user, userService.getUserByUsername(username));
		UserDTO userDTO = new UserDTO("VKS765", "Skrishna", "skrishna2341@mail.com", "Delhi", 834284821, "AIIMS");
		user = new User(userDTO.getUsername(), userDTO.getFullname(), userDTO.getEmail(), userDTO.getAddress(),
				userDTO.getMobile(), userDTO.getCompany());
		when(userRepo.save(user)).thenReturn(user);
		assertEquals("VKS765 Details were successfully updated.", userService.updateUserByUsername(username, userDTO));
	}

	@Test
	public void deleteUserByUsernameTest() {
		String username = "Balu453";
		User user = new User("Balu453", "Balu Prakash", "balu73@gmail.com", "Guntur", 987453121, "YSL");
		when(userRepo.findByUsername(username)).thenReturn(user);
		assertEquals(user, userService.getUserByUsername(username));
		userService.deleteUserByUsername(username);
		verify(userRepo, times(1)).delete(user);
	}

}
