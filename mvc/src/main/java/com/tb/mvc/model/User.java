package com.tb.mvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User implements IPojo {
	

	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;
	
	private String password;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
