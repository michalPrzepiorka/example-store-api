package com.example.store.repository.product;

import com.example.store.TypeOfClient;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author Y510p
 * @project store
 **/

public class ProductDummy {

    public static ProductBuilder exampleProduct() {
        return new ProductBuilder()
                .withId(UUID.randomUUID().toString())
                .withContent("Opis...")
                .withName("Słuchawki")
                .withPrice(BigDecimal.valueOf(199.99))
                .withTypeOfClient(TypeOfClient.MALE);
    }
}
