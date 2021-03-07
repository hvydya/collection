package com.colbackend.collection.repositories;

import com.colbackend.collection.models.CollectionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * created on: 03/03/21
 * created by: harsha
 */

public interface CollectionItemRepository extends JpaRepository<CollectionItem, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM collection_item ci WHERE ci.collection_id = :col_id"
    )
    List<CollectionItem> findByCollectionId(@Param("col_id") Long col_id);
}
