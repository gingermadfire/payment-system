package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.dto.PaymentDto;
import com.gingermadfire.testtask.mapper.PaymentMapper;
import com.gingermadfire.testtask.persistence.Payment;
import com.gingermadfire.testtask.repository.PaymentHibernateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final BillerService billerService;
    private final CustomerService customerService;
    private final PaymentHibernateRepository paymentHibernateRepository;
    private final PaymentMapper paymentMapper;

    public Payment find(Long id) {
        return paymentHibernateRepository.find(id);
    }

    public List<PaymentDto> findAll(){
        return paymentHibernateRepository.findAll()
                .stream()
                .map(paymentMapper::map)
                .toList();
    }

    @Transactional
    public void save(PaymentDto dto){
        Payment payment = new Payment();
        payment.setAccount(dto.getAccount());
        payment.setAmount(dto.getAmount());
        payment.setBiller(billerService.find(dto.getBiller().getId()));
        payment.setCustomer(customerService.find(dto.getCustomer().getId()));

        paymentHibernateRepository.save(payment);
    }

    public void delete(Long id){
        paymentHibernateRepository.delete(id);
    }

}