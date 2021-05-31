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
        restaurant = restaurantRepository.save(restaurant);

        return restaurant;
    }

    public void deleteRestaurantById(long id){
        restaurantRepository.deleteById(id);
    }

    //put
    public Restaurant putRestaurantById(Restaurant restaurant){ //image
        return  restaurantRepository.updateRestaurant(restaurant.getRestaurantName(),restaurant.getDetails());
    }

    public List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(long id){
        return restaurantRepository.findById(id); // ne radi mi exception .orElseThrow()
    }
}
