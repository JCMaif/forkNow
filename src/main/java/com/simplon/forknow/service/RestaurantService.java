package com.simplon.forknow.service;

import com.simplon.forknow.dto.RestaurantDto;
import com.simplon.forknow.model.Cuisine;
import com.simplon.forknow.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    void saveRestaurant(RestaurantDto restaurant, List<Cuisine> cuisines);

    public List<Restaurant> getAllRestaurants();
    public Optional<Restaurant> findRestaurantByName(String name);

    Optional<Restaurant> findRestaurantById(Long restaurantId);

}
