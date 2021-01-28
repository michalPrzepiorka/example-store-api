package com.example.store;

import com.example.store.client.TestClient;
import com.example.store.repository.ServiceManagement;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Y510p
 * @project store
 **/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(value = "integration")
class BaseIntegrationTest {

    @Autowired
    protected TestClient client;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ServiceManagement serviceManagement;

    @Autowired
    private MongoTemplate mongoTemplate;

    @AfterEach
    void tearDown() {
        mongoTemplate.getCollectionNames()
                .forEach(mongoTemplate::dropCollection);
    }
}
