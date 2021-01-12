package com.example.store;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Y510p
 * @project store
 **/

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
