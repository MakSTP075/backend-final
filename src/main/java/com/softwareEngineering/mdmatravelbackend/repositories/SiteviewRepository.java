package com.softwareEngineering.mdmatravelbackend.repositories;
import com.softwareEngineering.mdmatravelbackend.data.models.Siteview;
import com.softwareEngineering.mdmatravelbackend.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface SiteviewRepository extends JpaRepository<Siteview, Long> {
    @Modifying
    @Query("delete from Siteview s where s.id=:id")
    long deleteById(long id);

    @Modifying
    @Query(value = "select top 1 from Siteview s where s.id=:id", nativeQuery = true)
    Siteview findById(long id);

    @Modifying
    @Query(value = "select * from Siteview", nativeQuery = true)
    Siteview findAll(long id); // ZASTO MI NIJE ISKORISTEN

    @Modifying
    @Query(value = "UPDATE Siteview SET siteviewName = :name, details = :details WHERE s.id = id", nativeQuery = true)
    Siteview updateSiteview(String name, String details);

    // ADD ????

}