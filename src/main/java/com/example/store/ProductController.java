package com.example.store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Y510p
 * @project store
 **/

@RestController
public class ProductController {

    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
            value = "products"
    )
    public List<Product> showProducts() {
        return repository.findAll();
    }
}
