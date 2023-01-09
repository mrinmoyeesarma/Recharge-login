package com.recharge.login.service;

import com.recharge.login.entity.User;
import com.recharge.login.payload.UserDto;

public interface LoginService {

	User register(UserDto userDto);

}
