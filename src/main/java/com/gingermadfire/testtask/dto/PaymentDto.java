package com.gingermadfire.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private long id;

    private CustomerDto customer;

    private BillerDto biller;

    private String account;

    private BigDecimal amount;

    private Instant dateTime;
}
