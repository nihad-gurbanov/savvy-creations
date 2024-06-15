package com.holberton.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInDTO {
    private String username;
    private String password;
    private String fcmToken;
}
