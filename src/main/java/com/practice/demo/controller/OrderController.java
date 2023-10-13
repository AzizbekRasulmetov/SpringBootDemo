package com.practice.demo.controller;

import com.practice.demo.dto.HttpResponse;
import com.practice.demo.dto.OrderDTO;
import com.practice.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    public ResponseEntity<HttpResponse> createOrder(@RequestBody OrderDTO order) {
        // FIXME: 10/8/2023
        return orderService.createOrder(order, 1);
    }

}