package com.softwareEngineering.mdmatravelbackend.services.mapper;

import com.softwareEngineering.mdmatravelbackend.data.models.Restaurant;
import com.softwareEngineering.mdmatravelbackend.data.models.RegisterRestaurantDto;

import org.mapstruct.Mapper;

@Mapper

public interface RestaurantMapper {
    default Restaurant toEntity(RegisterRestaurantDto restaurantRegisterDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantRegisterDto.getRestaurantName());
        restaurant.setDetails(restaurantRegisterDto.getDetails());
        // image

        return restaurant;
    }
}
