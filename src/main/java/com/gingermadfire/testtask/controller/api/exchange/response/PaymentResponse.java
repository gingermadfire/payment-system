package com.gingermadfire.testtask.controller.api.exchange.response;

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
public class PaymentResponse {

    private long id;

    private CustomerResponse customer;

    private BillerResponse biller;

    private String account;

    private BigDecimal amount;

    private Instant dateTime;
}
