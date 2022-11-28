package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.persistence.Payment;
import com.gingermadfire.testtask.repository.PaymentHibernateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentHibernateRepository paymentHibernateRepository;

    public Payment find(Long id) {
        return paymentHibernateRepository.find(id);
    }

    public List<Payment> findAll(){
        return paymentHibernateRepository.findAll();
    }

    @Transactional
    public void save(Payment payment){
        paymentHibernateRepository.save(payment);
    }

    public void delete(Long id){
        paymentHibernateRepository.delete(id);
    }

}