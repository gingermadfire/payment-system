package com.gingermadfire.testtask.mapper;

import com.gingermadfire.testtask.dto.BillerDto;
import com.gingermadfire.testtask.persistence.Biller;
import org.springframework.stereotype.Component;

@Component
public class BillerMapper {

    public BillerDto map(Biller biller) {
        BillerDto dto = new BillerDto();

        dto.setId(biller.getId());
        dto.setCompanyName(biller.getCompanyName());

        return dto;
    }
}
