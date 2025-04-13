package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "captain")
@Getter
@Setter
public class Captain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String licenseNumber;
    private double avgRatingScore;

    @OneToMany(mappedBy = "captain", cascade = CascadeType.ALL)
    private List<Trip> trips;

}
