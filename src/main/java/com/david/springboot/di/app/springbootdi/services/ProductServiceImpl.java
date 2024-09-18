package com.david.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.david.springboot.di.app.springbootdi.models.Product;
import com.david.springboot.di.app.springbootdi.repositories.IProductRepository;

//en el service se maneja la logica de negocio
@Service
public class ProductServiceImpl implements ProductService {

    private IProductRepository repository;
    @Autowired
    private Environment environment;
    @Value("${config.price.tax}")
    private double tax;

    public ProductServiceImpl(@Qualifier("productJson") IProductRepository repository) {// qualifier para
        // intectar mediante
        // el nombre
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        System.out.println(tax);
        // se tomo el precio y se le sumo un 25% de impuesto
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
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
