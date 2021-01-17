package com.example.store.product.views.service;

import com.example.store.product.views.response.FetchProductViewsResponse;
import com.example.store.product.views.model.ProductViews;
import com.example.store.product.views.repository.ProductViewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Y510p
 * @project store
 **/

@Service
@AllArgsConstructor
public class ProductViewsService {

    private ProductViewsRepository repository;

    public int getViews(String productId) {
        ProductViews productView = repository.findByProductId(productId);
        if (productView == null)
            return 0;
        return productView.getCounter();
    }

    public void incrementRetrievesCounterOfProductWithId(String productId) {
        ProductViews productView = repository.findByProductId(productId);
        if (productView == null) {
            repository.save(new ProductViews("", 1, productId));
            return;
        }
        productView.setCounter(productView.getCounter() + 1);
        repository.save(productView);
    }

    public FetchProductViewsResponse getViewsOfProductByProductId(String productId) {
        ProductViews view = repository.findByProductId(productId);
        return new FetchProductViewsResponse(view.getCounter());
    }
}
