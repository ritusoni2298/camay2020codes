package com.application.ecommerce.repositories;

import com.application.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
@Repository
//@RestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

}
