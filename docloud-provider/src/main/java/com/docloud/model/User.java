package com.docloud.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = -6673680579428564627L;
	Long id;
	private String name;
	private Integer age;

	public User() {
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}
