package com.softwareEngineering.mdmatravelbackend.repositories;

import com.softwareEngineering.mdmatravelbackend.data.models.Rate;
import com.softwareEngineering.mdmatravelbackend.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query(value = "")
    public Double findAvarageByID();

    @Query("select  from Rate where (r.id=:id)")
    Rate findAvarageRateRestaurantByID(@Param("email") String email);


    @Query("select  from Rate where (h.id=:id)")
    Rate findAvarageRateHistoricByID(@Param("email") String email);


    @Query("select from Rate where (s.id=:id)")
    Rate findAvarageRateSiteviewByID(@Param("email") String email);
}
