package com.david.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.springboot.di.app.springbootdi.models.Product;
import com.david.springboot.di.app.springbootdi.repositories.IProductRepository;

//en el service se maneja la logica de negocio
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> findAll() {
        // se tomo el precio y se le sumo un 25% de impuesto
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            // Product newProduct = new Product(p.getId(), p.getName(),
            // priceImp.longValue());//una manera de manejar imutabilidad
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
