package com.ripon.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "user", schema = "db007")
public class User {
	
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "fname", nullable = false)
	private String fname;
	@Column(name = "lname", nullable = false)
	private String lname;
	@Column(name = "mobile", nullable = false)
	private String mobile;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "gender", nullable = false)
	private String gender;

	//getters and setters
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
