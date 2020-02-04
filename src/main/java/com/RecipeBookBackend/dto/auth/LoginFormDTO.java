package com.RecipeBookBackend.dto.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginFormDTO {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
}

