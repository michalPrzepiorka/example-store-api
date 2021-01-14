package com.example.store.product.repository;

import com.example.store.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Y510p
 * @project store
 **/

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);
}
