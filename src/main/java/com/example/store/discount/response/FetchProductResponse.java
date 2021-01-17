package com.example.store.discount.response;

import com.example.store.TypeOfClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;

/**
 * @author Y510p
 * @project store
 **/

@Value
@Getter
@AllArgsConstructor
public class FetchProductResponse {

    String name;
    String content;
    TypeOfClient typeOfClient;
    BigDecimal price;
}
