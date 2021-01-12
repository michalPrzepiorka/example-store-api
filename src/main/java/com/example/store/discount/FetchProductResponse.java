package com.example.store.discount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;

/**
* @project store
* @author Y510p
**/

@Value
@Getter
@AllArgsConstructor
public class FetchProductResponse {

    String id;
    String name;
    String content;
    TypeOfClient typeOfClient;
    BigDecimal price;
}
