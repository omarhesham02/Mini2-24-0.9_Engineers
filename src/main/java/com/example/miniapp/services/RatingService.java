package com.example.miniapp.services;

import com.example.miniapp.models.Rating;
import com.example.miniapp.repositories.RatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(String id, Rating updatedRating) {
        Optional<Rating> optionalRating = ratingRepository.findById(id);
        if (optionalRating.isPresent()) {
            Rating existingRating = optionalRating.get();
            existingRating.setScore(updatedRating.getScore());
            existingRating.setComment(updatedRating.getComment());
            return ratingRepository.save(existingRating);
        }
        return null;
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }

    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        System.out.println("Looking for entityId=" + entityId + ", type=" + entityType);

        Query query = new Query();
        query.addCriteria(Criteria.where("entityId").is(entityId));
        query.addCriteria(Criteria.where("entityType").is(entityType));

        List<Rating> ratings = mongoTemplate.find(query, Rating.class);
        System.out.println("Raw MongoTemplate result size: " + ratings.size());
        return ratings;
    }



    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
