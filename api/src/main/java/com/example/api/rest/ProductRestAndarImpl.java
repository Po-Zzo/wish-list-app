package com.example.api.rest;

import com.example.api.dto.ProductListAndarRequestBody;
import com.example.api.dto.ProductListAndarResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ProductRestAndarImpl implements ProductRest {

    private final RestTemplate restTemplate;

    @Value("${api.andar.productList}")
    private String ANDAR_PRODUCT_LIST_API;

    public ProductRestAndarImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ProductListAndarResponseBody getProductList() {
        return restTemplate.postForEntity(ANDAR_PRODUCT_LIST_API,
                ProductListAndarRequestBody.of(),
                ProductListAndarResponseBody.class).getBody();
    }
}
