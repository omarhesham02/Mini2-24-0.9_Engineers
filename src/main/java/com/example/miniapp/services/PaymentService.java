package com.example.miniapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    // payment model :
    // private Long id;

    // private double amount;
    // private String paymentMethod;
    // private boolean paymentStatus;
    // private Trip trip;

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        // Optional<User> user = userRepository.findById(id);
        // if(user.isEmpty()){
        // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        // }
        // return user.get();

        // maybe throw error, instead of returning null, like the above?
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found"));
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        existingPayment.setPaymentStatus(payment.isPaymentStatus());
        existingPayment.setTrip(payment.getTrip());
        return paymentRepository.save(existingPayment);
    }

    public void deletePayment(Long id) {
        Optional<Payment> foundPayment = paymentRepository.findById(id);
        if (foundPayment.isPresent()) {
            paymentRepository.delete(foundPayment.get());
        }
    }

    public List<Payment> findPaymentsByTripId(Long tripId) {
        List<Payment> payments = paymentRepository.findByTripId(tripId);
        if (payments.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No payments found for this trip");
        }
        return payments;
    }

    public List<Payment> findByAmountThreshold(Double threshold) {
        List<Payment> payments = paymentRepository.findByAmountGreaterThan(threshold);
        if (payments.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No payments found above this amount");
        }
        return payments;
    }
}
