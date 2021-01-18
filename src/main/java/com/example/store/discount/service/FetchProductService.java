package com.example.store.discount.service;

import com.example.store.product.model.Product;
import com.example.store.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Y510p
 * @project store
 **/

@Service
@AllArgsConstructor
public class FetchProductService {

    private ProductRepository repository;

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}
