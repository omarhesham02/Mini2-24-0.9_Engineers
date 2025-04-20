package com.example.miniapp.services;

import com.example.miniapp.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    public Customer addCustomer(Customer customer) {
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return List.of();
    }
}
