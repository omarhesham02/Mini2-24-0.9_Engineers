package com.example.miniapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Document(collection = "ratings")
public class Rating {

    @Id
    private String id;

    private Long entityId;
    private String entityType;

    @Min(1)
    @Max(5)
    private Integer score;

    private String comment;
    private LocalDateTime created;

    public Rating() {
        this.created = LocalDateTime.now();
    }

    public Rating(Long entityId, String entityType, Integer score, String comment) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.created = LocalDateTime.now();
    }

    public Rating(String id, Long entityId, String entityType, Integer score, String comment, LocalDateTime created) {
        this.id = id;
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.created = created;
    }

    public Rating(Long entityId, String entityType, Integer score, String comment, LocalDateTime created) {
        this.entityId = entityId;
        this.entityType = entityType;
        this.score = score;
        this.comment = comment;
        this.created = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Long getEntityId() {
        return entityId;
    }

    public String getEntityType() {
        return entityType;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
