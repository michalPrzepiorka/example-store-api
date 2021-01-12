package com.example.store.product.model;

import com.example.store.discount.TypeOfClient;
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
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String content;
    private TypeOfClient typeOfClient;
    private BigDecimal price;
}
