package com.example.store.product.controller;

import com.example.store.discount.response.FetchProductResponse;
import com.example.store.discount.service.FetchProductService;
import com.example.store.product.model.Product;
import com.example.store.product.repository.ProductRepository;
import com.example.store.product.views.response.FetchProductViewsResponse;
import com.example.store.product.views.service.ProductViewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

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
    private ProductViewsService viewsService;

    public ProductController(ProductRepository repository, FetchProductService service, ProductViewsService viewsService) {
        this.repository = repository;
        this.service = service;
        this.viewsService = viewsService;
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
    public FetchProductResponse showProductByNameAfterDiscount(@PathVariable String name) {
        viewsService.incrementRetrievesCounterOfProductWithId(service.getProductByName(name).getId());
        return service.getFetchedProductWithNewPriceByName(name);
    }

    @GetMapping(
            value = "/views/{productId}"
    )
    public FetchProductViewsResponse getViewOfProductByProductId(@PathVariable String productId) {
        return viewsService.getViewsOfProductByProductId(productId);
    }
}
