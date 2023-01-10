package com.gingermadfire.testtask.service;

import com.gingermadfire.testtask.controller.api.exchange.response.BillerResponse;
import com.gingermadfire.testtask.mapper.BillerMapper;
import com.gingermadfire.testtask.persistence.Biller;
import com.gingermadfire.testtask.repository.BillerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillerService {
    private final BillerRepository billerRepository;
    private final BillerMapper billerMapper;

    public Biller find(Long id) {
        return billerRepository.find(id);
    }

    public List<BillerResponse> findAll() {
        return billerRepository.findAll()
                .stream()
                .map(billerMapper::map)
                .toList();
    }

    @Transactional
    public void save(BillerResponse dto) {
        Biller biller = new Biller();
        biller.setId(dto.getId());
        biller.setCompanyName(dto.getCompanyName());

        billerRepository.save(biller);
    }

    public void delete(Long id) {
        billerRepository.delete(id);
    }
}
