package me.project.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.project.model.User;
import me.project.repository.UserRepository;
import me.project.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		
	this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
			throw new IllegalArgumentException("This user ID already exist");
		}
		return userRepository.save(userToCreate);
	}

}
