package com.gingermadfire.testtask.repository;

import com.gingermadfire.testtask.persistence.Payment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PaymentHibernateRepository implements PaymentRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Payment find(Long id) {
        return entityManager.find(Payment.class, id);
    }

    @Override
    public List<Payment> findAll() {
        return entityManager.createQuery("select p from Payment p", Payment.class).getResultList();
    }

    @Override
    public void save(Payment payment) {
        entityManager.persist(payment);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("delete from Payment p where p.id in (:id)")
                .setParameter("id", id);
    }
}
