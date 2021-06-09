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
    @Query(value = "select * from Comment where h.id=:id", nativeQuery = true)
    Comment findCommentsByHistoricID(long id);

    @Modifying
    @Query(value = "select * from Comment where r.id=:id", nativeQuery = true)
    Comment findCommentsByRestaurantID(long id);

    @Modifying
    @Query(value = "select * from Comment where s.id=:id", nativeQuery = true)
    Comment findCommentsBySiteviewID(long id);

}
