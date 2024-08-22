package com.simplon.forknow.dto;

import com.simplon.forknow.model.UtilisateurRole;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupDto {
    @NotEmpty(message = "Username doit être renseigné")
    private String username;

    @NotEmpty(message = "Email doit être renseigné")
    private String email;

    @NotEmpty(message = "Password doit être renseigné")
    private String password;

    @NotEmpty(message = "PasswordConfirm doit être renseigné")
    private String passwordConfirm;

    @NotEmpty(message = "Votre status doit être renseigné")
    private UtilisateurRole role;
}
