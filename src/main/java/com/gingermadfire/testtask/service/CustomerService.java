package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.persistence.Customer;
import com.gingermadfire.testtask.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer find(Long id) {
        return customerRepository.find(id);
    }
}
