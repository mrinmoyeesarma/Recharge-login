package com.recharge.login.service;

import com.recharge.login.entity.User;
import com.recharge.login.payload.LoginDto;
import com.recharge.login.payload.UserDto;

public interface LoginService {

	boolean login(LoginDto loginDto);
	User register(UserDto userDto);

}
