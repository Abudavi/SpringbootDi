package com.david.springboot.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.david.springboot.di.app.springbootdi.repositories.IProductRepository;
import com.david.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    IProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();
    }
}
