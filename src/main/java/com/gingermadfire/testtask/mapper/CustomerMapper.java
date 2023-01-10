package com.gingermadfire.testtask.mapper;

import com.gingermadfire.testtask.controller.api.exchange.response.CustomerResponse;
import com.gingermadfire.testtask.persistence.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerResponse map(Customer customer) {
        CustomerResponse dto = new CustomerResponse();

        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());

        return dto;
    }
}
