package com.simplon.forknow.service.impl;

import com.simplon.forknow.model.Cuisine;
import com.simplon.forknow.repository.CuisineRepository;
import com.simplon.forknow.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuisineServiceImpl implements CuisineService {

    private final CuisineRepository cuisineRepository;

    @Autowired
    public CuisineServiceImpl(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }

    @Override
    public Cuisine saveCuisine(Cuisine cuisine) {
        return cuisineRepository.save(cuisine);
    }

    @Override
    public Optional<Cuisine> findCuisineByType(String type) {
        return cuisineRepository.findByType(type);
    }

    @Override
    public List<Cuisine> findAllCuisines() {
        return cuisineRepository.findAll();
    }
}
