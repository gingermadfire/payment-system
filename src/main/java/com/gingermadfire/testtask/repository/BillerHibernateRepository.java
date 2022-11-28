package com.gingermadfire.testtask.repository;

import com.gingermadfire.testtask.persistence.Biller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BillerHibernateRepository implements BillerRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Biller find(Long id) {
        return entityManager.find(Biller.class, id);
    }

    @Override
    public List<Biller> findAll() {
        return entityManager.createQuery("select b from Biller b",Biller.class).getResultList();
    }

    @Override
    public void save(Biller biller) {
        entityManager.persist(biller);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("delete from Biller where Biller.id IN (:id)")
                .setParameter("id", id);

    }
}
