package com.gingermadfire.testtask.mapper;

import com.gingermadfire.testtask.dto.CustomerDto;
import com.gingermadfire.testtask.persistence.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto map(Customer customer) {
        CustomerDto dto = new CustomerDto();

        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());

        return dto;
    }
}
