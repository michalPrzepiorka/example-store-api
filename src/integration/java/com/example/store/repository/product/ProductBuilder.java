package com.example.store.repository.product;

import com.example.store.TypeOfClient;
import com.example.store.product.model.Product;
import groovy.transform.builder.Builder;

import java.math.BigDecimal;

/**
 * @author Y510p
 * @project store
 **/

@Builder
public class ProductBuilder {

    private String id;
    private String name;
    private String content;
    private TypeOfClient typeOfClient;
    private BigDecimal price;

    public ProductBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    public ProductBuilder withTypeOfClient(TypeOfClient typeOfClient) {
        this.typeOfClient = typeOfClient;
        return this;
    }

    public ProductBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(id, name, content, typeOfClient, price);
    }
}
