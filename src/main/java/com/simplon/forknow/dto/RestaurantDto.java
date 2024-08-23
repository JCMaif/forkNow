package com.simplon.forknow.dto;

import com.simplon.forknow.model.Cuisine;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestaurantDto {
    @NotEmpty(message = "l'enseigne doit être renseignée")
    private String name;

    private String imageName;

    private List<Long> cuisines;
}
