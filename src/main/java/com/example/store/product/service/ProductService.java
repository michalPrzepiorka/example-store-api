package com.example.store.product.service;

import com.example.store.product.model.ProductProvider;
import com.example.store.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author Y510p
 * @project store
 **/

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void saveProduct() {
        repository.deleteAll();
        ProductProvider.getListOfProduct()
                .forEach(repository::save);
    }
}
