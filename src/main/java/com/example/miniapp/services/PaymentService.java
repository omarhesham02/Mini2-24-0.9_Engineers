package com.example.miniapp.services;

import org.springframework.stereotype.Service;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;

@Service
public class PaymentService {

    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
}
