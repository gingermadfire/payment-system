package com.gingermadfire.testtask.controller.api;

import com.gingermadfire.testtask.controller.api.exchange.response.CustomerResponse;
import com.gingermadfire.testtask.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerRestController {
    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getAll() {
        return customerService.findAll();
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> save(@Valid @RequestBody CustomerResponse dto) {
        customerService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
