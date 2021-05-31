package com.softwareEngineering.mdmatravelbackend.repositories;

import com.softwareEngineering.mdmatravelbackend.data.models.Comment;
import com.softwareEngineering.mdmatravelbackend.data.models.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Modifying
    @Query(value = "select * from Comment", nativeQuery = true)
    Comment findAll(long id); // ZASTO MI NIJE ISKORISTEN

    // ADD ?

    // posto ce na svakom itemu npr na restoranu sezam tenis da mi nece oonda ispisat sve komentare iz svih itema nego samo iz tog

}
