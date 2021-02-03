package com.example.store.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Y510p
 * @project store
 **/

@Lazy
@Component
public class TestClient {

    @LocalServerPort
    private int localServerPort;

    @Autowired
    private MockMvc mockMvc;

    public ResultActions sendGetProductsDiscounted() throws Exception {
        return mockMvc.perform(get("http://localhost:" + localServerPort + "/product/discounted/Słuchawki"));
    }
}
