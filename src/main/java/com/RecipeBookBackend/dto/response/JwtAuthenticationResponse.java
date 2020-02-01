package com.RecipeBookBackend.dto.response;

import com.RecipeBookBackend.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {

    private String tokenType = "Bearer";
    private int jwtExpirationInMs;
    private String accessToken;
    private UserDTO user;

    public JwtAuthenticationResponse(String accessToken, UserDTO userDTO, int jwtExpirationInMs) {
        this.accessToken = accessToken;
        this.user = userDTO;
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

}
