package com.softwareEngineering.mdmatravelbackend.services;

import com.softwareEngineering.mdmatravelbackend.data.models.*;
import com.softwareEngineering.mdmatravelbackend.repositories.RestaurantRepository;
import com.softwareEngineering.mdmatravelbackend.services.mapper.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Transactional()
    public Restaurant registerRestaurant(RegisterRestaurantDto restaurantRegister) {
        log.debug("Request to REGISTER restaurant : {}", restaurantRegister);
        Restaurant restaurant = restaurantMapper.toEntity(restaurantRegister);
        restaurantRepository.save(restaurant);

        return restaurant;
    }

    public void deleteRestaurantById(long id){
        restaurantRepository.deleteById(id);
    }

    public Restaurant putRestaurantById(Restaurant restaurant){
        Restaurant oldRestaurant = restaurantRepository.findById(restaurant.getId()).orElseThrow();
        oldRestaurant.setRestaurantName(restaurant.getRestaurantName());
        oldRestaurant.setDetails(restaurant.getDetails());
        restaurantRepository.save(oldRestaurant);
        return  oldRestaurant;
    }

    public List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(long id){
        return restaurantRepository.findById(id); // ne radi mi exception .orElseThrow()
    }
}
