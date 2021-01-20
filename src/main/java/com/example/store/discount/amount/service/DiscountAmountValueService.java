package com.example.store.discount.amount.service;

import com.example.store.TypeOfClient;
import com.example.store.discount.amount.model.Discount;
import com.example.store.discount.amount.model.DiscountAmountValue;
import com.example.store.discount.amount.model.PercentageDiscount;
import com.example.store.discount.amount.providers.DiscountAmountValueProvider;
import com.example.store.discount.amount.repository.DiscountAmountValueRepository;
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
                .forEach(repository::save);
    }

    public Discount getDiscount(TypeOfClient type) {
        DiscountAmountValue discountEntity = repository.findByTypeOfClient(type);
        if (discountEntity == null) {
            return new PercentageDiscount(BigDecimal.ZERO);
        }
        return new PercentageDiscount(discountEntity.getDiscount());
    }
}
