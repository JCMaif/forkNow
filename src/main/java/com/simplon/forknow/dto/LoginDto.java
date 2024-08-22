package com.simplon.forknow.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotEmpty(message = "Username doit être renseigné")
    private String username;

    @NotEmpty(message = "Password doit être renseigné")
    private String password;
}
