package com.may2020.crudDemo.repository;

import com.may2020.crudDemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //dao
    //findById
    //Query (SPEL)
    //native queries (SQL)
    //Named queries (Attributes)

    List<Product> findByName(String name);
    //startswith endsWith

    @Query(value = "select * from products where name = ?1 and spec_details= ?2", nativeQuery = true) //native //spel
    List<Product> findByNameAndSpec(String name, String spec);

    @Query(value = "select * from products order by name",nativeQuery = true)
    List<Product> findAllByOrderName();

    @Query(value = "select id from products where name=:name",nativeQuery = true)
    List<Integer> findByNameParam(@Param("name") String name);


}
//console..
