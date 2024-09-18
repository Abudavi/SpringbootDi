package com.david.springboot.di.app.springbootdi.repositories;

import java.util.List;

import com.david.springboot.di.app.springbootdi.models.Product;

public interface IProductRepository {

    List<Product> findAll();

    Product findById(Long id);

}
