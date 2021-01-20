package com.example.store.product.controller;

import com.example.store.discount.amount.model.Discount;
import com.example.store.discount.amount.service.DiscountAmountValueService;
import com.example.store.discount.response.FetchProductResponse;
import com.example.store.product.model.Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Y510p
 * @project store
 **/

public class ProductResponseMapper {

    private ProductResponseMapper() {
    }

    public static List<FetchProductResponse> mapToProductResponses(List<Product> products, DiscountAmountValueService discountService) {
        return products.stream()
                .map(product -> mapToProductResponse(product, discountService))
                .collect(Collectors.toList());
    }

    public static FetchProductResponse mapToProductResponseByName(DiscountAmountValueService discountService, Product product) {
        Discount discount = discountService.getDiscount(product.getTypeOfClient());
        discount.applyTo(product);

        return FetchProductResponse.builder()
                .name(product.getName())
                .content(product.getContent())
                .typeOfClient(product.getTypeOfClient())
                .price(product.getPrice())
                .build();
    }

    private static FetchProductResponse mapToProductResponse(Product product, DiscountAmountValueService discountService) {
        Discount discount = discountService.getDiscount(product.getTypeOfClient());
        discount.applyTo(product);

        return FetchProductResponse.builder()
                .name(product.getName())
                .content(product.getContent())
                .typeOfClient(product.getTypeOfClient())
                .price(product.getPrice())
                .build();
    }
}
