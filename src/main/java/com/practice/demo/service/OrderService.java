package com.practice.demo.service;

import com.practice.demo.dto.HttpResponse;
import com.practice.demo.dto.OrderDTO;
import com.practice.demo.enums.HttpStatus;
import com.practice.demo.mapper.OrderMapper;
import com.practice.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    public ResponseEntity<HttpResponse> createOrder(OrderDTO orderDTO, long customerID) {
        orderRepository.save(orderMapper.toEntity(orderDTO));
        return ResponseEntity.ok(new HttpResponse(HttpStatus.CREATED));
    }

}
