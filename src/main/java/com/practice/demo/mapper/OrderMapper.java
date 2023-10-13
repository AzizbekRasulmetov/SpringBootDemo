package com.practice.demo.mapper;

import com.practice.demo.dto.OrderDTO;
import com.practice.demo.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderEntity toEntity(OrderDTO orderDTO) {
        return new OrderEntity();
    }

    public OrderDTO toDTO(OrderEntity order) {
        return new OrderDTO(
                order.getId(),
                order.getOrderDate(),
                order.getDeliveryDate()
        );
    }

}
