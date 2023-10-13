package com.practice.demo.controller;

import com.practice.demo.dto.CustomerDTO;
import com.practice.demo.dto.HttpResponse;
import com.practice.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/create")
    public ResponseEntity<HttpResponse> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return service.createCustomer(customerDTO);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@RequestParam long id) {
        return service.getCustomerById(id);
    }

}
