package com.gingermadfire.testtask.repository;


import com.gingermadfire.testtask.persistence.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer find(Long id);

    List<Customer> findAll();

    void save(Customer customer);

    void delete(Long id);
}
