package com.may2020.crudDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

//product <--- onetomany ----> order
//product( id, name, spec, price )
//order (id, name, spec,product_id) < fk
@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderName;

    private String orderDetails;

    @ManyToOne
    @JoinColumn(name="product_id",nullable = false)
    @JsonIgnore
    private Product product;

}

