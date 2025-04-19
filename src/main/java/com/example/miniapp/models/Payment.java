package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String paymentMethod;
    private boolean paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    // Default constructor
    public Payment() {
    }

    // full constructor
    public Payment(double amount, String paymentMethod, boolean paymentStatus, Trip trip) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.trip = trip;
    }

    // TODO: make sure, which fields to include ? (test cases may help)
    // partial constructor
    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
}
