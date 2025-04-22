package com.example.miniapp.repositories;

import com.example.miniapp.models.Rating;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;

public interface RatingRepository extends MongoRepository<Rating, String> {

    @Query("{ 'entityId': ?0, 'entityType': ?1 }")
    List<Rating> findByEntityIdAndEntityType(Long entityId, String entityType);
    List<Rating> findByScoreGreaterThan(int score);
}
