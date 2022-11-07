package com.gingermadfire.testtask.repository;

import com.gingermadfire.testtask.persistence.Biller;

import java.util.List;

public interface BillerRepository {
    Biller find(Long id);

    List<Biller> findAll();

    void save(Biller biller);

    void delete(Long id);

}
