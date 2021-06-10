package com.softwareEngineering.mdmatravelbackend.repositories;
import com.softwareEngineering.mdmatravelbackend.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select e from User e where lower(e.email) = lower(:email)")
    User findByEmail(@Param("email") String email);


    @Query(value = "select top 1 from User u where u.id=:id", nativeQuery = true)
    User findById(long id);


    @Query(value = "select * from User", nativeQuery = true)
    User findAll(long id);


    @Modifying
    @Query(value = "UPDATE User SET password = :password WHERE user.id = id", nativeQuery = true)
    User updateUser(String password);
}
