package com.practice.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

//@Entity
@Data
public class ProductEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//    @Column(name = "category_name", length = 150)
//    private String category;
//    private String name;
//    @Column(columnDefinition = "NUMERIC(15,0) default 0")
//    private Double price;
//    @ManyToMany(mappedBy = "products")
//    @JsonBackReference
//    private List<OrderEntity> orders;
}
