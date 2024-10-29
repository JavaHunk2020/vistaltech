package com.boot.model;

import java.util.function.Consumer;

public class PeopleDTO {
	private Long pid;
	private String email;
	private String name;
	private String gender;
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PeopleDTO [email=" + email + ", name=" + name + ", gender=" + gender + "]";
	}

}
