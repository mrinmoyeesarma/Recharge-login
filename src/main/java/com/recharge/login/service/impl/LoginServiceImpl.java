package com.recharge.login.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recharge.login.entity.User;
import com.recharge.login.payload.UserDto;
import com.recharge.login.repository.UserRepository;
import com.recharge.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserRepository userRepository;

//	public LoginServiceImpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}

	public String login(UserDto user) {
		Optional<User> u= userRepository.findByUserNameAndPasswordAndIsAdmin(user.getUsername(), user.getPassword(), user.isAdmin());
		if(u.isPresent()) {
			return "true";
		}else {
			return "false";
		}
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
