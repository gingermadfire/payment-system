package com.gingermadfire.testtask.controller.api.exchange.request;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private long billerId;

    private long customerId;

    private String account;

    private BigDecimal amount;
}
