package com.gingermadfire.testtask.mapper;

import com.gingermadfire.testtask.controller.api.exchange.response.PaymentResponse;
import com.gingermadfire.testtask.persistence.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMapper {
    private final BillerMapper billerMapper;
    private final CustomerMapper customerMapper;

    public PaymentResponse map(Payment payment) {
        PaymentResponse dto = new PaymentResponse();

        dto.setId(payment.getId());
        dto.setCustomer(customerMapper.map(payment.getCustomer()));
        dto.setBiller(billerMapper.map(payment.getBiller()));
        dto.setAccount(payment.getAccount());
        dto.setAmount(payment.getAmount());
        dto.setDateTime(payment.getDateTime());

        return dto;
    }

}
