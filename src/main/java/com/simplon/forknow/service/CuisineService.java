package com.simplon.forknow.service;

import com.simplon.forknow.model.Cuisine;

import java.util.List;
import java.util.Optional;

public interface CuisineService {
    public Cuisine saveCuisine(Cuisine cuisine);

    public Optional<Cuisine> findCuisineByType(String type);

    public List<Cuisine> findAllCuisines();

    public Optional<Cuisine> findById(Long id);


}
