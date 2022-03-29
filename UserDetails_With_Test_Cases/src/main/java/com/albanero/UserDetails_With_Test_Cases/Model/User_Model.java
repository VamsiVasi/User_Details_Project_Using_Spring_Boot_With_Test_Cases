package com.albanero.UserDetails_With_Test_Cases.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class User_Model {

	@Id
	private int id;
	private String username;
	private String fullname;
	private String email;
	private String address;
	private long mobile;
	private String company;

	public User_Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_Model(int id, String username, String fullname, String email, String address, long mobile, String company) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
