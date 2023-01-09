package com.recharge.login.service.impl;


import org.springframework.stereotype.Service;

import com.recharge.login.entity.User;
import com.recharge.login.payload.UserDto;
import com.recharge.login.repository.UserRepository;
import com.recharge.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	private UserRepository userRepository;

	public LoginServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User register(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setAdmin(userDto.isAdmin());
		User userCreated = userRepository.save(user);
		userCreated.setPassword("N/A");
		 return userCreated;
	}
}
