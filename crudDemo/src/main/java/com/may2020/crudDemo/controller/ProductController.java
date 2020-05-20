package com.may2020.crudDemo.controller;

import com.may2020.crudDemo.model.Product;
import com.may2020.crudDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class ProductController {
     //dispatcher servlet
    //custom customer
    //http://localhost:8080/getProduct -> list of product -> GET -> READ (DATABASE)
    //---------------------/addproduct -> {name, spec, price} -> POST -> CREATE (DATABASE)
    //---------------------/updateproduct -> {match id} {name, spec, price} -> PUT -> UPDATE (DATABASE)
    //---------------------/delete -> {id} -> DELETE -> DELETE (DATABASE)

    //controller -> call -> data access layer (JPA) -> call -> database (select * from products)
    //jdbc
    //hibernate //methods to handle the data of queries
    //spring data jpa -> findById(long id) ,save(product) , findAll()<list of products>

    //dev tools

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    List<Product> getProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }

    @PostMapping("/products")
    Product addProduct(@Valid @RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    Product updateProduct(@PathVariable(name = "id") Long id,@Valid @RequestBody Product product) throws Exception{
        Optional<Product> oldProduct = productRepository.findById(id);
        if(oldProduct.isPresent()){
            //product consists of new values -> oldProduct
            oldProduct.get().setName(product.getName());
            oldProduct.get().setPrice(product.getPrice());
            oldProduct.get().setSpecDetails(product.getSpecDetails());
            //.save
            return productRepository.save(oldProduct.get());
        }else{
            throw new Exception("Invalid id");
        }
    }
    @GetMapping("/productname")
    List<Product> getProductByName(@RequestParam(name = "name")String name, @RequestParam(name = "spec") String spec){
//        String name = "cookies";
        return productRepository.findByNameAndSpec(name,spec);
    }

    @GetMapping("/orderedproducts")
    List<Product> getProductOrderByName(){
        return productRepository.findAllByOrderName();
    }

    @GetMapping("/productnames")
    List<Integer> getProductNames(@RequestParam(name="name") String name){
        return productRepository.findByNameParam(name);
    }

    @DeleteMapping("/products/{id}")
    String deleteProduct(@PathVariable Long id) throws Exception{
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            return  "Deleted!";
        }else{
            throw new Exception("Invalid id");
        }
    }


}
