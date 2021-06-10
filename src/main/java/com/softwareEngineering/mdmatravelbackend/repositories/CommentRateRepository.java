package com.softwareEngineering.mdmatravelbackend.repositories;
import com.softwareEngineering.mdmatravelbackend.data.models.CommentRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CommentRateRepository extends JpaRepository<CommentRate, Long> {

    @Modifying
    @Query(value = "SELECT * FROM CommentRate cr WHERE cr.id=:id", nativeQuery = true)
    List<CommentRate> getAllRestaurantCR(long id);

    @Query(value = "SELECT * FROM CommentRate cr WHERE cr.id=:id", nativeQuery = true)
    List<CommentRate> getAllHistoricCR(long id);

    @Query(value = "SELECT * FROM CommentRate cr WHERE cr.id=:id", nativeQuery = true)
    List<CommentRate> getAllSiteviewCR(long id);




}

