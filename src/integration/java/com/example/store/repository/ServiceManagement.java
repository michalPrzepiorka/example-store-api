package com.example.store.repository;

import com.example.store.discount.amount.repository.DiscountAmountValueRepository;
import com.example.store.product.repository.ProductRepository;
import com.example.store.repository.product.ProductBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Y510p
 * @project store
 **/

@Component
public class ServiceManagement {
    private final ProductRepository productRepository;
    private final DiscountAmountValueRepository discountAmountValueRepository;

    public ServiceManagement(ProductRepository productRepository, DiscountAmountValueRepository discountAmountValueRepository) {
        this.productRepository = productRepository;
        this.discountAmountValueRepository = discountAmountValueRepository;
    }

    public void saveProduct(ProductBuilder productBuilder) {
        productRepository.save(productBuilder.build());
    }
}
