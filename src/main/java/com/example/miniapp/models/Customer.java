package com.example.miniapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Trip> trips;

    public Customer(String johnDoe, String mail, String number) {
        this.name = johnDoe;
        this.email = mail;
        this.phoneNumber = number;
    }

    public Customer() {

    }
}
