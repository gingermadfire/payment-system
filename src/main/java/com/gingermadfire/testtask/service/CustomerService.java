package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.persistence.Customer;
import com.gingermadfire.testtask.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer find(Long id) {
        return customerRepository.find(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.delete(id);
    }
}
