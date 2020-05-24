package com.demo.springcloud.mapper;

import com.demo.springcloud.entities.Product;

import java.util.List;

public interface ProductMapper {

    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);
}
