package com.gingermadfire.testtask.mapper;

import com.gingermadfire.testtask.dto.PaymentDto;
import com.gingermadfire.testtask.persistence.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMapper {
    private final BillerMapper billerMapper;
    private final CustomerMapper customerMapper;

    public PaymentDto map(Payment payment) {
        PaymentDto dto = new PaymentDto();

        dto.setId(payment.getId());
        dto.setCustomer(customerMapper.map(payment.getCustomer()));
        dto.setBiller(billerMapper.map(payment.getBiller()));
        dto.setAccount(payment.getAccount());
        dto.setAmount(payment.getAmount());
        dto.setDateTime(payment.getDateTime());

        return dto;
    }

}
