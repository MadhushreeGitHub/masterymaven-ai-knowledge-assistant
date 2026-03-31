package com.masterymaven.backend.repository;

import com.masterymaven.backend.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DocumentRepository extends JpaRepository<Document, UUID> {

    @Query("""
            SELECT d 
            FROM Document d 
            WHERE LOWER(d.content) 
            LIKE LOWER(CONCAT('%', :query, '%'))
        """)
    List<Document> search(@Param("query") String query);
}
