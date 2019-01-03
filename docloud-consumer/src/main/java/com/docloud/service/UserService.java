package com.docloud.service;

import com.docloud.model.User;

import java.util.List;

public interface UserService {
	User find(Long id);

	List<User> findAll(List<Long> ids);
}
