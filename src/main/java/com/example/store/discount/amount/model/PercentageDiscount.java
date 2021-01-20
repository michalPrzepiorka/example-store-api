package com.example.store.discount.amount.model;

import com.example.store.product.model.Product;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Y510p
 * @project store
 **/

@AllArgsConstructor
public class PercentageDiscount implements Discount {
    private final BigDecimal percentage;

    @Override
    public void applyTo(Product product) {
        product.setPrice(product.getPrice().subtract(
                product
                        .getPrice()
                        .min(product.getPrice()
                                .multiply(percentage)
                        )
        ).setScale(2, RoundingMode.DOWN));
    }
}
