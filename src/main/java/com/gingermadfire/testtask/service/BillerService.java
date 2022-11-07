package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.persistence.Biller;
import com.gingermadfire.testtask.repository.BillerHibernateRepository;
import com.gingermadfire.testtask.repository.BillerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillerService {
    private final BillerRepository billerRepository;

    public Biller find(Long id) {
        return billerRepository.find(id);
    }

    public List<Biller> findAll() {
        return billerRepository.findAll();
    }

    @Transactional
    public void save(Biller biller) {
        billerRepository.save(biller);
    }

    public void delete(Long id) {
        billerRepository.delete(id);
    }
}
