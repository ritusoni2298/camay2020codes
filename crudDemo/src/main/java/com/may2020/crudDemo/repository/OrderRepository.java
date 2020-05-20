package com.may2020.crudDemo.repository;

import com.may2020.crudDemo.model.Order;
import com.may2020.crudDemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    public List<Order> findByProduct(Product product);
}
