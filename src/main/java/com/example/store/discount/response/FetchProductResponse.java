package com.example.store.discount.response;

import com.example.store.TypeOfClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author Y510p
 * @project store
 **/

@Builder
@Getter
@AllArgsConstructor
public class FetchProductResponse {

    String name;
    String content;
    TypeOfClient typeOfClient;
    BigDecimal price;
}
