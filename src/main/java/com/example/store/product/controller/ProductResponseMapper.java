package com.example.store.product.controller;

import com.example.store.discount.amount.service.DiscountAmountValueService;
import com.example.store.discount.response.FetchProductResponse;
import com.example.store.product.model.Product;

import java.math.RoundingMode;
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
        return FetchProductResponse.builder()
                .name(product.getName())
                .content(product.getContent())
                .typeOfClient(product.getTypeOfClient())
                .price(product.getPrice().subtract(
                        product
                                .getPrice()
                                .min(product.getPrice()
                                        .multiply(discountService.getDiscountValue(product.getTypeOfClient()))
                                )
                ).setScale(2, RoundingMode.DOWN))
                .build();
    }

    private static FetchProductResponse mapToProductResponse(Product product, DiscountAmountValueService discountService) {
        return FetchProductResponse.builder()
                .name(product.getName())
                .content(product.getContent())
                .typeOfClient(product.getTypeOfClient())
                .price(product.getPrice().subtract(
                        product
                                .getPrice()
                                .min(product.getPrice()
                                        .multiply(discountService.getDiscountValue(product.getTypeOfClient()))
                                )
                ).setScale(2, RoundingMode.DOWN))
                .build();
    }
}
