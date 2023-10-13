package com.practice.demo.mapper;

import com.practice.demo.dto.CustomerDTO;
import com.practice.demo.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomerMapper {

    public CustomerEntity toEntity(CustomerDTO customerDTO) {
        return new CustomerEntity(
                customerDTO.getId(),
                customerDTO.getName(),
                Collections.emptyList()
        );
    }

    public CustomerDTO toDTO(CustomerEntity customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName()
        );
    }

}
