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
    @Query("delete from Restaurant r where r.id=:id")
    long deleteById(long id);

    @Modifying
    @Query(value = "select top 1 from Restaurant r where r.id=:id", nativeQuery = true)
    Restaurant findById(long id);

    @Modifying
    @Query(value = "select * from Restaurant", nativeQuery = true)
    Restaurant findAll(long id); //zasto mi nije iskoristen

    @Modifying
    @Query(value = "UPDATE Restaurant SET restaurantName = :name, details = :details WHERE restaurant.id = id", nativeQuery = true)
    Restaurant updateRestaurant(String name, String details);

    // ADD RECORD ??
}
