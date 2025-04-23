package com.example.miniapp.services;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    public Customer updateCustomer(Long id, Customer customer) {
        customerRepository.updateCustomer(id, customer.getName(), customer.getEmail(), customer.getPhoneNumber());
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    public void deleteCustomer(Long id) { customerRepository.deleteById(id); }

    public List<Customer> findCustomersByEmailDomain(String domain) { return customerRepository.findCustomersByEmailDomain(domain); }

    public List<Customer> findCustomersByPhonePrefix(String prefix) { return customerRepository.findCustomersByPhonePrefix(prefix);}

}
