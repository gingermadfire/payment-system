package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.controller.api.exchange.request.PaymentRequest;
import com.gingermadfire.testtask.controller.api.exchange.response.PaymentResponse;
import com.gingermadfire.testtask.mapper.request.PaymentRequestMapper;
import com.gingermadfire.testtask.mapper.response.PaymentResponseMapper;
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
    private final PaymentResponseMapper paymentResponseMapper;
    private final PaymentRequestMapper paymentRequestMapper;

    public Payment find(Long id) {
        return paymentHibernateRepository.find(id);
    }

    public List<PaymentResponse> findAll() {
        return paymentHibernateRepository.findAll()
                .stream()
                .map(paymentResponseMapper::map)
                .toList();
    }

    @Transactional
    public void save(PaymentRequest dto) {
        Payment payment = paymentRequestMapper.map(dto);
        paymentHibernateRepository.save(payment);
    }

    public void delete(Long id) {
        paymentHibernateRepository.delete(id);
    }

}