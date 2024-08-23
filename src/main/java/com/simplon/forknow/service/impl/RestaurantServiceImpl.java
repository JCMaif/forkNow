package com.simplon.forknow.service.impl;

import com.simplon.forknow.dto.RestaurantDto;
import com.simplon.forknow.model.Cuisine;
import com.simplon.forknow.model.Restaurant;
import com.simplon.forknow.repository.RestaurantRepository;
import com.simplon.forknow.service.CuisineService;
import com.simplon.forknow.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final CuisineService cuisineService; // Ajout de l'injection de dépendance

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, CuisineService cuisineService) {
        this.restaurantRepository = restaurantRepository;
        this.cuisineService = cuisineService;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findRestaurantByName(String name) {
        return restaurantRepository.findByName(name);
    }

    @Override
    public Optional<Restaurant> findRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        if (restaurantRepository.existsById(restaurantId)) {
            restaurantRepository.deleteById(restaurantId);
        } else {
            throw new RuntimeException("Restaurant with ID " + restaurantId + " not found.");
        }
    }
}
