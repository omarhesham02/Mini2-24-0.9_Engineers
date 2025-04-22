package com.example.miniapp.repositories;

import com.example.miniapp.models.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Modifying
    @Transactional
    @Query(value = "UPDATE customers SET name =: customer.name, email =: customer.email, phone_number =: customer.phoneNumber WHERE id =: customer.id", nativeQuery = true)
    void updateCustomer(@Param(value = "customer") Customer customer);

    @Query(value = "SELECT * FROM customers WHERE name LIKE '%' || '@' || :domain", nativeQuery = true)
    List<Customer> findCustomersByEmailDomain(@Param("domain") String domain);

    @Query(value = "SELECT * FROM customers WHERE phoneNumber LIKE :prefix || '%'", nativeQuery = true)
    List<Customer> findCustomersByPhonePrefix(@Param("prefix") String prefix);
}
