package com.example.miniapp.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ratings")
@Getter
@Setter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long entityId;
    private String entityType;

    @Min(value = 1)
    @Max(value = 5)
    private Integer score;

    private String comment;
    private LocalDateTime created;

    public Rating(long l, String customer, int i, String s, LocalDateTime now) {
        this.entityId = l;
        this.entityType = customer;
        this.score = i;
        this.comment = s;
        this.created = now;
    }
}
