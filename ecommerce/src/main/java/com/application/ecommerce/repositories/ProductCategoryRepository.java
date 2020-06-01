package com.application.ecommerce.repositories;

import com.application.ecommerce.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "productCategory", path="product-categories")
@Repository
//@RestResource
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
