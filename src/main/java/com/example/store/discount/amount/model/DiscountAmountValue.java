package com.example.store.discount.amount.model;

import com.example.store.TypeOfClient;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @author Y510p
 * @project store
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "discount")
public class DiscountAmountValue {

    @Id
    private String id;
    TypeOfClient typeOfClient;
    BigDecimal discount;
}
