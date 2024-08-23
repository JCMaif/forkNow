package com.simplon.forknow.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.List;

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

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("NOW()")
    private Date creation_date;

    private UtilisateurRole role;


    @ManyToMany
    @JoinTable(
            name = "utilisateur_restaurant",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id")
    )
    private List<Restaurant> restaurants;

}
