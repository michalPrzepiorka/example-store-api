package com.example.store.discount.amount.model;

import com.example.store.product.model.Product;

/**
 * @author Y510p
 * @project store
 **/

public interface Discount {
    void applyTo(Product product);
}
