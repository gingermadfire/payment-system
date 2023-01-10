package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.controller.api.exchange.response.CustomerResponse;
import com.gingermadfire.testtask.mapper.CustomerMapper;
import com.gingermadfire.testtask.persistence.Customer;
import com.gingermadfire.testtask.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public Customer find(Long id) {
        return customerRepository.find(id);
    }

    public List<CustomerResponse> findAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::map)
                .toList();
    }

    @Transactional
    public void save(CustomerResponse dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());

        customerRepository.save(customer);
    }

    public void delete(Long id) {
        customerRepository.delete(id);
    }
}
