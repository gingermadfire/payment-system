package com.gingermadfire.testtask.mapper.response;

import com.gingermadfire.testtask.controller.api.exchange.response.PaymentResponse;
import com.gingermadfire.testtask.persistence.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentResponseMapper {
    private final BillerResponseMapper billerResponseMapper;
    private final CustomerResponseMapper customerResponseMapper;

    public PaymentResponse map(Payment payment) {
        PaymentResponse dto = new PaymentResponse();

        dto.setId(payment.getId());
        dto.setCustomer(customerResponseMapper.map(payment.getCustomer()));
        dto.setBiller(billerResponseMapper.map(payment.getBiller()));
        dto.setAccount(payment.getAccount());
        dto.setAmount(payment.getAmount());
        dto.setDateTime(payment.getDateTime());

        return dto;
    }

}
