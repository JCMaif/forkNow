package com.simplon.forknow.service.impl;

import com.simplon.forknow.dto.RestaurantDto;
import com.simplon.forknow.model.Cuisine;
import com.simplon.forknow.model.Restaurant;
import com.simplon.forknow.repository.RestaurantRepository;
import com.simplon.forknow.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void saveRestaurant(RestaurantDto restaurant, List<Cuisine> cuisines) {
        Restaurant restauEntity = Restaurant.builder()
                .name(restaurant.getName())
                .imageName(restaurant.getImageName())
                .cuisines(cuisines)
                .build();
        restaurantRepository.save(restauEntity);
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
}
