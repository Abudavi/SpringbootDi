package com.david.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.springboot.di.app.springbootdi.models.Product;
import com.david.springboot.di.app.springbootdi.services.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping()
    public List<Product> list() {

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return productService.findById(id);
    }

}
