package com.example.store;

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
                .stream()
                .map(product -> new Product(
                        product.getId(),
                        product.getName(),
                        product.getContent(),
                        product.getTypeOfClient(),
                        product.getPrice())
                ).forEach(repository::save);
    }
}
