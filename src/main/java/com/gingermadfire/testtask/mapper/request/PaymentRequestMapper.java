package com.gingermadfire.testtask.mapper.request;

import com.gingermadfire.testtask.controller.api.exchange.request.PaymentRequest;
import com.gingermadfire.testtask.persistence.Payment;
import com.gingermadfire.testtask.service.BillerService;
import com.gingermadfire.testtask.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PaymentRequestMapper {
    private final CustomerService customerService;
    private final BillerService billerService;

    public Payment map(PaymentRequest request) {
        Payment payment = new Payment();

        payment.setCustomer(customerService.find(request.getCustomerId()));
        payment.setBiller(billerService.find(request.getBillerId()));
        payment.setAccount(request.getAccount());
        payment.setAmount(request.getAmount());

        return payment;
    }

}
