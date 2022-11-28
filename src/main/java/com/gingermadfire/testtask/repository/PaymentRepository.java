package com.gingermadfire.testtask.repository;

import com.gingermadfire.testtask.persistence.Payment;

import java.util.List;

public interface PaymentRepository {

    Payment find(Long id);

    List<Payment> findAll();

    void save(Payment payment);

    void delete(Long id);
}
