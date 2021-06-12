package com.softwareEngineering.mdmatravelbackend.repositories;
import com.softwareEngineering.mdmatravelbackend.data.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


    @Modifying
    @Query(value = "select * from Restaurant", nativeQuery = true)
    Restaurant findAll(long id);
    @Modifying
    @Query(value = "UPDATE Restaurant SET restaurantName = :name, details = :details WHERE restaurant.id = id", nativeQuery = true)
    Restaurant updateRestaurant(String name, String details);

}
