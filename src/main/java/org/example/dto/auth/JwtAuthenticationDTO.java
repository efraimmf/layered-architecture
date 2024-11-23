package org.example.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationDTO {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
