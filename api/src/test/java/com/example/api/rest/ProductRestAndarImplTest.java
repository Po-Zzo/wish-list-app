package com.example.api.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext
@RestClientTest(value = ProductRestAndarImpl.class,
excludeAutoConfiguration = MockRestServiceServerAutoConfiguration.class)
class ProductRestAndarImplTest  {

    @Autowired
    private ProductRestAndarImpl productRestAndar;

    @Test
    @DisplayName("rest 요청이 에러 없음")
    void getProductList() {
        productRestAndar.getProductList();
    }
}
