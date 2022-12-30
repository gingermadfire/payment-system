package com.gingermadfire.testtask.controller.api;

import com.gingermadfire.testtask.dto.PaymentDto;
import com.gingermadfire.testtask.persistence.Payment;
import com.gingermadfire.testtask.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentRestController {
    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDto> getAll() {
        return paymentService.findAll();
    }

    @PostMapping
    public ResponseEntity<PaymentDto> save(@RequestBody PaymentDto dto) {
        paymentService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
