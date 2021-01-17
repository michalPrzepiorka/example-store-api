package com.example.store.product.views.repository;

import com.example.store.product.views.model.ProductViews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Y510p
 * @project store
 **/

@Repository
public interface ProductViewsRepository extends MongoRepository<ProductViews, String> {

    ProductViews findByProductId(String id);
}
