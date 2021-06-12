package com.softwareEngineering.mdmatravelbackend.repositories;

import com.softwareEngineering.mdmatravelbackend.data.models.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
public interface HistoricRepository extends JpaRepository<Historic, Long> {


    @Modifying
    @Query(value = "select * from Historic", nativeQuery = true)
    Historic findAll(long id);

    @Modifying
    @Query(value = "UPDATE Historic SET historicName = :name, details = :details WHERE historic.id = id", nativeQuery = true)
    Historic updateHistoric(String name, String details);
}
