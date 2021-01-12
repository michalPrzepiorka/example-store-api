package com.example.store.discount.amount;

import com.example.store.discount.TypeOfClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Y510p
 * @project store
 **/

@Repository
public interface DiscountAmountValueRepository extends MongoRepository<DiscountAmountValue, String> {

    DiscountAmountValue findByTypeOfClient(TypeOfClient type);
}
