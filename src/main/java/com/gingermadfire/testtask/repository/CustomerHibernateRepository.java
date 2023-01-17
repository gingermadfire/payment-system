package com.gingermadfire.testtask.repository;


import com.gingermadfire.testtask.persistence.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CustomerHibernateRepository implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer find(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);

    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("DELETE FROM Customer WHERE Customer.id IN (:id)")
                .setParameter("id", id);

    }
}
