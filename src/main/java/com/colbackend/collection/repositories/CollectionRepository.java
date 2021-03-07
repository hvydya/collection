package com.colbackend.collection.repositories;

import com.colbackend.collection.models.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;


/**
 * created on: 03/03/21
 * created by: harsha
 */

public interface CollectionRepository extends JpaRepository<Collection, Long> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM collection c WHERE c.name = :name"
    )
    Optional<Collection> findByName(@Param("name") String name);
}
