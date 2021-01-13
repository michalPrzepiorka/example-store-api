package com.example.store.discount;

import com.example.store.discount.amount.DiscountAmountValueService;
import com.example.store.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Y510p
 * @project store
 **/

@Service
@AllArgsConstructor
public class FetchProductService {

    private ProductRepository repository;
    DiscountAmountValueService service;

    public List<FetchProductResponse> getFetchedProductWithNewPrice() {
        return repository.findAll()
                .stream()
                .map(product -> new FetchProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getContent(),
                        product.getTypeOfClient(),
                        product.getPrice().subtract(
                                product.getPrice().min(product.getPrice().multiply(service.getDiscountValue(product.getTypeOfClient())))
                        )
                )).collect(Collectors.toList());
    }
}
