package com.gingermadfire.testtask.mapper.response;

import com.gingermadfire.testtask.controller.api.exchange.response.BillerResponse;
import com.gingermadfire.testtask.persistence.Biller;
import org.springframework.stereotype.Component;

@Component
public class BillerResponseMapper {

    public BillerResponse map(Biller biller) {
        BillerResponse dto = new BillerResponse();

        dto.setId(biller.getId());
        dto.setCompanyName(biller.getCompanyName());

        return dto;
    }
}
