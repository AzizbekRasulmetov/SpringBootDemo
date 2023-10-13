package com.practice.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate orderDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate deliveryDate;
    private String status;
//    @ManyToOne
//    @JoinColumn(name = "id")
    private Long customerId;
//    @ManyToOne
//    @JoinColumn(name = "customer")
//    @JsonBackReference
    /*@JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_items",
            joinColumns = {@JoinColumn(table = "order_product", name = "fk_order_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(table = "product", referencedColumnName = "id", name = "fk_product_id")})*/
//    private List<ProductEntity> products;
}
