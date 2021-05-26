package com.softwareEngineering.mdmatravelbackend.repositories;

import com.softwareEngineering.mdmatravelbackend.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select e from User e where lower(e.email) = lower(:email)")
    User findByEmail(@Param("email") String email);
}
