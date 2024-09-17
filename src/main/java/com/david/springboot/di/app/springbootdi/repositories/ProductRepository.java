package com.david.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import com.david.springboot.di.app.springbootdi.models.Product;

//se optienen solo los datos
public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria Coirsair", 300L),
                new Product(2L, "Cpu i5 ", 850L),
                new Product(3L, "Teclado razer 60%", 180L),
                new Product(4L, "Motherboard gigabyte", 490L));
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {

        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}
