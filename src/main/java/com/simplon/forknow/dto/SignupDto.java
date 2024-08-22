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
public class SignupDto {
    @NotEmpty(message = "Username doit être renseigné")
    private String username;

    @NotEmpty(message = "Email doit être renseigné")
    private String email;

    @NotEmpty(message = "Password doit être renseigné")
    private String password;

    @NotEmpty(message = "PasswordConfirm doit être renseigné")
    private String passwordConfirm;
}
