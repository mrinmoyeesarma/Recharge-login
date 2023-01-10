package com.recharge.login.payload;

import lombok.Data;

@Data
public class LoginResponseDto {
    String loginMessage;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
}
