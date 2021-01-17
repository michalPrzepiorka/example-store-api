package com.example.store.discount.amount.providers;

import com.example.store.TypeOfClient;
import com.example.store.discount.amount.model.DiscountAmountValue;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Y510p
 * @project store
 **/

public class DiscountAmountValueProvider {

    public static List<DiscountAmountValue> getListOfDiscount() {
        List<DiscountAmountValue> discount = new LinkedList<>();

        discount.add(new DiscountAmountValue("", Enum.valueOf(TypeOfClient.class, "MALE"), BigDecimal.valueOf(0.05)));
        discount.add(new DiscountAmountValue("", Enum.valueOf(TypeOfClient.class, "FEMALE"), BigDecimal.valueOf(0.05)));
        discount.add(new DiscountAmountValue("", Enum.valueOf(TypeOfClient.class, "KID"), BigDecimal.valueOf(0.1)));

        return discount;
    }
}
