package com.simplon.forknow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imageName;

    @ManyToMany(mappedBy = "restaurants")
    private List<Utilisateur> utilisateurs;

    @ManyToMany
    @JoinTable(
            name = "restaurant_cuisine",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "cuisine_id")
    )
    private List<Cuisine> cuisines;
}
