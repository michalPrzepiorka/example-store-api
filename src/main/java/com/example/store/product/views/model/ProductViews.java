package com.example.store.product.views.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Y510p
 * @project store
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "views")
public class ProductViews {

    @Id
    private String id;
    private int counter;
    private String productId;
}
