package com.gingermadfire.testtask.controller.api;

import com.gingermadfire.testtask.controller.api.exchange.request.PaymentRequest;
import com.gingermadfire.testtask.controller.api.exchange.response.PaymentResponse;
import com.gingermadfire.testtask.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentRestController {
    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentResponse> getAll() {
        return paymentService.findAll();
    }

    @PostMapping
    public ResponseEntity<PaymentRequest> save(@Valid @RequestBody PaymentRequest dto) {
        paymentService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
