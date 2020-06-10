package com.application.ecommerce.repositories;

import com.application.ecommerce.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "products", path = "products")
//@Repository
@CrossOrigin("*")
//@RestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource(path ="categoryid")
    public Page<Product> findByProductCategoryId(@Param("id") Long id, Pageable pageable);

    @RestResource(path="findbykeyword")
    public Page<Product> findByNameContains(@Param("keyword") String name, Pageable pageable);

}
