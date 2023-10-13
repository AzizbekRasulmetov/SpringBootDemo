package com.practice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class OrderDTO {

    private long id;
    private LocalDate orderDate;
    private LocalDate deliveryDate;

}
