package com.softwareEngineering.mdmatravelbackend.repositories;

import com.softwareEngineering.mdmatravelbackend.data.models.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
public interface HistoricRepository extends JpaRepository<Historic, Long> {
    @Modifying
    @Query("delete from Historic h where h.id=:id")
    long deleteById(long id);

    @Modifying
    @Query(value = "select top 1 from Historic h where h.id=:id", nativeQuery = true)
    Historic findById(long id);

    @Modifying
    @Query(value = "select * from Historic", nativeQuery = true)
    Historic findAll(long id);

    @Modifying
    @Query(value = "UPDATE Historic SET historicName = :name, details = :details WHERE historic.id = id", nativeQuery = true)
    Historic updateHistoric(String name, String details);

    //@Modifying
    //@Query(value = "INSERT INTO Historic (historicName, details) VALUES (:name,:details)”, nativeQuery = true)
     //       Historic registerHistoric(String name, String details);
}
