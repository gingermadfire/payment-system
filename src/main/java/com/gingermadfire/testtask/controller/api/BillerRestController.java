package com.gingermadfire.testtask.controller.api;

import com.gingermadfire.testtask.controller.api.exchange.response.BillerResponse;
import com.gingermadfire.testtask.service.BillerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/billers")
public class BillerRestController {
    private final BillerService billerService;

    @GetMapping
    public List<BillerResponse> getAll() {
        return billerService.findAll();
    }

    @PostMapping
    public ResponseEntity<BillerResponse> save(@RequestBody BillerResponse dto) {
        billerService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
