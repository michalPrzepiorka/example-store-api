package com.example.store;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Y510p
 * @project store
 **/

public class ProductProvider {

    public static List<Product> getListOfProduct() {
        List<Product> product = new LinkedList<>();

        product.add(new Product("", "Golarka", "Jakiś opis...", "MALE", BigDecimal.valueOf(199.99)));
        product.add(new Product("", "Prostownica", "Jakiś opis...", "MALE", BigDecimal.valueOf(149.99)));
        product.add(new Product("", "Klocki LEGO", "Jakiś opis...", "MALE", BigDecimal.valueOf(299.99)));

        return product;
    }
}
