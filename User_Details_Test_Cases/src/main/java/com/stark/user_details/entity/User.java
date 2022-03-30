package com.stark.user_details.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "Users")
@Getter
@Setter
public class User {

	@Id
	private String id;
	private String username;
	private String fullname;
	private String email;
	private String address;
	private long mobile;
	private String company;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String fullname, String email, String address, long mobile, String company) {
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
		return "User [id=" + id + ", username=" + username + ", fullname=" + fullname + ", email=" + email
				+ ", address=" + address + ", mobile=" + mobile + ", company=" + company + "]";
	}

}
