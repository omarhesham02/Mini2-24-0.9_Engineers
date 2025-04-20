package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "captains")
@Getter
@Setter
public class Captain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private double avgRatingScore;

    public Captain(String name, String licenseNumber, double avgRatingScore) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.avgRatingScore = avgRatingScore;
    }

    public Captain() {

    }

    @OneToMany(mappedBy = "captain", cascade = CascadeType.ALL)
    private List<Trip> trips;

}
