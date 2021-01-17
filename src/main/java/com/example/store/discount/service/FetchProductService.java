package com.example.store.discount.service;

import com.example.store.discount.response.FetchProductResponse;
import com.example.store.discount.amount.service.DiscountAmountValueService;
import com.example.store.product.model.Product;
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
    private DiscountAmountValueService service;

    public List<FetchProductResponse> getFetchedProductWithNewPrice() {
        return repository.findAll()
                .stream()
                .map(product -> new FetchProductResponse(
                        product.getName(),
                        product.getContent(),
                        product.getTypeOfClient(),
                        product.getPrice().subtract(
                                product.getPrice().min(product.getPrice().multiply(service.getDiscountValue(product.getTypeOfClient())))
                        )
                )).collect(Collectors.toList());
    }

    public FetchProductResponse getFetchedProductWithNewPriceByName(String name) {
        Product product = repository.findByName(name);
        return new FetchProductResponse(
                product.getName(),
                product.getContent(),
                product.getTypeOfClient(),
                product.getPrice().subtract(
                        product.getPrice().min(product.getPrice().multiply(service.getDiscountValue(product.getTypeOfClient())))
                ));
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }
}
