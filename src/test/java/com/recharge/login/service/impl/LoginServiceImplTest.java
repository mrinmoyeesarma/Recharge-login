package com.recharge.login.service.impl;

import com.recharge.login.entity.User;
import com.recharge.login.payload.LoginDto;
import com.recharge.login.payload.LoginResponseDto;
import com.recharge.login.payload.UserDto;
import com.recharge.login.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginServiceImplTest {
    private LoginServiceImpl loginService;
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        // Initialize
        loginService = new LoginServiceImpl();

        // Mockito
        userRepository = Mockito.mock(UserRepository.class);

        // Reflection Test Utils
        ReflectionTestUtils.setField(loginService, "userRepository", userRepository);
    }

    @Test
    void testLogin1() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("HI");
        loginDto.setPassword("HI");
        Mockito.when(userRepository.findByUsernameAndPassword(Mockito.any(), Mockito.any())).thenReturn(Optional.empty());
        LoginResponseDto loginResponseDto = loginService.login(loginDto);
        assertEquals("UnAuthorized", loginResponseDto.getLoginMessage());
    }

    @Test
    void testLogin2() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("HI");
        loginDto.setPassword("HI");
        User user = new User();
        Mockito.when(userRepository.findByUsernameAndPassword(Mockito.any(), Mockito.any())).thenReturn(Optional.of(user));
        LoginResponseDto loginResponseDto = loginService.login(loginDto);
        assertEquals("Authorized", loginResponseDto.getLoginMessage());
    }

    @Test
    void testRegister1() {
        User user = new User();
        UserDto userDto = new UserDto();
        userDto.setUsername("HI");
        Mockito.when(userRepository.findByUsername(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        User val = loginService.register(userDto);
        assertEquals("N/A", val.getPassword());
    }

    @Test
    void testRegister2() {
        User user = new User();
        UserDto userDto = new UserDto();
        Mockito.when(userRepository.findByUsername(Mockito.any())).thenReturn(Optional.of(user));
        User val = loginService.register(userDto);
        assertEquals(null, val);
    }
}
