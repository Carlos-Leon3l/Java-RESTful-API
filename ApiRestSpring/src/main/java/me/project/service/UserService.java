package me.project.service;

import me.project.model.User;

public interface UserService {
	
	User findById(Long id);
	
	User create(User user);
}
