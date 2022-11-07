package com.gingermadfire.testtask.controller.api;

import com.gingermadfire.testtask.persistence.Biller;
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
    public List<Biller> getAll() {
        return billerService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Biller biller) {
        billerService.save(biller);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
