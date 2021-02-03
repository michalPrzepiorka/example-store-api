package com.example.store.repository;

import com.example.store.TypeOfClient;
import com.example.store.discount.amount.repository.DiscountAmountValueRepository;
import com.example.store.product.model.Product;
import com.example.store.product.repository.ProductRepository;
import com.example.store.repository.product.DiscountBuilder;
import com.example.store.repository.product.ProductBuilder;
import com.example.store.repository.product.ProductDummy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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
