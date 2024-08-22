package com.simplon.forknow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cuisine")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    // Relation many-to-many avec les restaurants
    @ManyToMany(mappedBy = "cuisines")
    private List<Restaurant> restaurants;
}
