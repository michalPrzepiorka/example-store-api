package com.example.store.product.controller;

import com.example.store.discount.FetchProductResponse;
import com.example.store.discount.FetchProductService;
import com.example.store.product.model.Product;
import com.example.store.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Y510p
 * @project store
 **/

@RestController
@RequestMapping(
        value = "/product"
)
public class ProductController {

    private ProductRepository repository;
    private FetchProductService service;

    public ProductController(ProductRepository repository, FetchProductService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping(
            value = "/all"
    )
    public List<Product> showAllProduct() {
        return repository.findAll();
    }

    @GetMapping(
            value = "/discounted"
    )
    public List<FetchProductResponse> showAllProductAfterDiscount() {
        return new LinkedList<>(service.getFetchedProductWithNewPrice());
    }

    @GetMapping(
            value = "/discounted/{name}"
    )
    public Stream<FetchProductResponse> showProductByName(@PathVariable String name) {
        LinkedList<FetchProductResponse> fetchProductResponses = new LinkedList<>(service.getFetchedProductWithNewPrice());
        return fetchProductResponses.stream().filter(e -> e.getName().equals(name));
    }
}
