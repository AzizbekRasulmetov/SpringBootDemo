package com.practice.demo.service;

import com.practice.demo.dto.CustomerDTO;
import com.practice.demo.dto.HttpResponse;
import com.practice.demo.entity.CustomerEntity;
import com.practice.demo.enums.HttpStatus;
import com.practice.demo.exception.CustomerAlreadyExistsException;
import com.practice.demo.exception.CustomerNotFoundException;
import com.practice.demo.mapper.CustomerMapper;
import com.practice.demo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper mapper;

    public ResponseEntity<HttpResponse> createCustomer(CustomerDTO customerDTO) {
        try {
            customerRepository.findById(customerDTO.getId()).ifPresent((c) -> {
                throw new CustomerAlreadyExistsException();
            });
            customerRepository.save(mapper.toEntity(customerDTO));
            return ResponseEntity.ok(new HttpResponse(HttpStatus.CREATED));
        } catch (CustomerAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(
                    new HttpResponse(
                            e.getMessage(),
                            HttpStatus.BAD_REQUEST.getCode()
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                    new HttpResponse(
                            HttpStatus.INTERNAL_SERVER_ERROR
                    )
            );
        }
    }

    public ResponseEntity<CustomerDTO> getCustomerById(long id) {
        try {
            CustomerEntity customer = customerRepository.findById(id).orElseThrow(() -> {
                throw new CustomerNotFoundException();
            });
            return ResponseEntity.ok(mapper.toDTO(customer));
        } catch (Exception e) {
            //fixme
            return ResponseEntity.ok(new CustomerDTO(-1, null));
        }

    }

}
