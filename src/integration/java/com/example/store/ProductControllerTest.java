package com.example.store;

import com.example.store.repository.product.ProductDummy;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductControllerTest extends BaseIntegrationTest {

//    @Test
//    void should_get_discounted_product_by_name() throws Exception {
//        // given
//        // when
//        ResultActions response = mockMvc.perform(get("/product/discounted/Golarka"));
//        // then
//        response
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$.name", Matchers.is("Golarka")))
//                .andExpect(jsonPath("$.price", Matchers.is(189.99)));
//    }

    @Test
    void should_get_product_with_discount_for_male() throws Exception {
        // given
        serviceManagement.saveProduct(ProductDummy.exampleProduct());
        // when
        ResultActions response = client.sendGetProductsDiscounted();
        // then
        response
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.name", Matchers.is("Słuchawki")))
                .andExpect(jsonPath("$.content", Matchers.is("Opis...")))
                .andExpect(jsonPath("$.typeOfClient", Matchers.is("MALE")))
                .andExpect(jsonPath("$.price", Matchers.is(189.99)));
    }
}