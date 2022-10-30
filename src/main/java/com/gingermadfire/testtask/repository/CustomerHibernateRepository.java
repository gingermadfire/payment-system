package com.gingermadfire.testtask.repository;


import com.gingermadfire.testtask.persistence.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerHibernateRepository implements CustomerRepository {

    private final EntityManager entityManager;

    @Override
    public Customer find(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(Long id) {

    }
}
