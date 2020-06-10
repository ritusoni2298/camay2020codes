package com.application.ecommerce.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "productcategory")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductCategory implements Serializable {
    @Id
    Long id;
    String name;

    @OneToMany(mappedBy = "productCategory",fetch = FetchType.LAZY)
    Set<Product> products;

}
