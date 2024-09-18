package com.david.springboot.di.app.springbootdi.services;

import java.util.List;

import com.david.springboot.di.app.springbootdi.models.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

}
