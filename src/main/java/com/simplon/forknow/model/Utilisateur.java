package com.simplon.forknow.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Table(name = "utilisateur")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String username;

    private String display_name;

    @NonNull
    private String email;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("NOW()")
    private Date creation_date;

    private UtilisateurRole role;

}
