package com.example.store.discount.amount;

import com.example.store.discount.TypeOfClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Y510p
 * @project store
 **/

@Service
@AllArgsConstructor
public class DiscountAmountValueService {

    private DiscountAmountValueRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void saveDiscount() {
        repository.deleteAll();
        DiscountAmountValueProvider.getListOfDiscount()
                .forEach(data -> repository.save(data));
    }

    public BigDecimal getDiscountValue(TypeOfClient type) {
        DiscountAmountValue discountEntity = repository.findByTypeOfClient(type);
        if (discountEntity == null) {
            return BigDecimal.ZERO;
        }
        return discountEntity.getDiscount();
    }
}
