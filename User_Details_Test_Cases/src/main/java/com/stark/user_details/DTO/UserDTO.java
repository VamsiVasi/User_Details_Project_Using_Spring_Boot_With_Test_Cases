package com.stark.user_details.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private String username;
	private String fullname;
	private String email;
	private String address;
	private long mobile;
	private String company;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String username, String fullname, String email, String address, long mobile, String company) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.company = company;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", fullname=" + fullname + ", email=" + email + ", address=" + address
				+ ", mobile=" + mobile + ", company=" + company + "]";
	}

}