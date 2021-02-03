package com.example.store.repository.product;

import com.example.store.TypeOfClient;
import com.example.store.discount.amount.model.DiscountAmountValue;
import groovy.transform.builder.Builder;

import java.math.BigDecimal;

/**
 * @author Y510p
 * @project store
 **/

@Builder
public class DiscountBuilder {

    private String id;
    private TypeOfClient typeOfClient;
    private BigDecimal discount;

    public DiscountBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public DiscountBuilder withTypeOfClient(TypeOfClient typeOfClient) {
        this.typeOfClient = typeOfClient;
        return this;
    }

    public DiscountBuilder withDiscountForMale(BigDecimal percent) {
        this.discount = percent;

        return this;
    }

    public DiscountBuilder withDiscountForFemale(ProductBuilder product) {
        this.discount = product.build().getPrice()
                .min(product.build().getPrice().multiply(BigDecimal.valueOf(0.05)));

        return this;
    }

    public DiscountBuilder withDiscountForKid(ProductBuilder product) {
        this.discount = product.build().getPrice()
                .min(product.build().getPrice().multiply(BigDecimal.valueOf(0.1)));

        return this;
    }

    public DiscountAmountValue build() {
        return new DiscountAmountValue(
                id, typeOfClient, discount
        );
    }
}
