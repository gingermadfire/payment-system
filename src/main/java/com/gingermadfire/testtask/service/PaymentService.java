package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.dto.PaymentDto;
import com.gingermadfire.testtask.persistence.Payment;
import com.gingermadfire.testtask.repository.PaymentHibernateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final BillerService billerService;
    private final CustomerService customerService;
    private final PaymentHibernateRepository paymentHibernateRepository;

    public Payment find(Long id) {
        return paymentHibernateRepository.find(id);
    }

    public List<Payment> findAll(){
        return paymentHibernateRepository.findAll();
    }

    @Transactional
    public void save(PaymentDto dto){
        Payment payment = new Payment();
        payment.setAccount(dto.getAccount());
        payment.setAmount(dto.getAmount());
        payment.setBiller(billerService.find(dto.getBillerId()));
        payment.setCustomer(customerService.find(dto.getCustomerId()));

        paymentHibernateRepository.save(payment);
    }

    public void delete(Long id){
        paymentHibernateRepository.delete(id);
    }

}