package com.example.miniapp.controllers;

import com.example.miniapp.models.Rating;
import com.example.miniapp.services.RatingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/addRating")
    public Rating addRating(@RequestBody Rating rating) {
        rating.setEntityType(rating.getEntityType().toLowerCase());
        if (rating.getEntityId() != null) {
            rating.setEntityId(Long.valueOf(rating.getEntityId()));
        }
        return ratingService.addRating(rating);
    }

    @PutMapping("/update/{id}")
    public Rating updateRating(@PathVariable String id, @RequestBody Rating updatedRating) {
        return ratingService.updateRating(id, updatedRating);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRating(@PathVariable String id) {
        ratingService.deleteRating(id);
        return "Rating with ID " + id + " has been deleted.";
    }

    @GetMapping("/findByEntity")
    public List<Rating> findRatingsByEntity(
            @RequestParam String entityId,
            @RequestParam String entityType
    ) {
        Long longId = Long.parseLong(entityId.trim());
        String cleanedType = entityType.trim().toLowerCase();
        return ratingService.getRatingsByEntity(longId, cleanedType);
    }


    @GetMapping("/findAboveScore")
    public List<Rating> findRatingsAboveScore(@RequestParam int minScore) {
        return ratingService.findRatingsAboveScore(minScore);
    }

    @GetMapping("/findAll")
    public List<Rating> getAllRatings() {
        return ratingService.getAllRatings();
    }

}
