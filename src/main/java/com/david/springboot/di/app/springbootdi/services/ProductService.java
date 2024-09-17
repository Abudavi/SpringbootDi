package com.david.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.david.springboot.di.app.springbootdi.models.Product;
import com.david.springboot.di.app.springbootdi.repositories.ProductRepository;

//en el service se maneja la logica de negocio
public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        // se tomo el precio y se le sumo un 25% de impuesto
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            p.setPrice(priceImp.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
