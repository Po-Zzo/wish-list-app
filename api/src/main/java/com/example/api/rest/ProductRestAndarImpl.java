package com.example.api.rest;

import static org.springframework.http.HttpMethod.GET;

import com.example.api.dto.ProductDetailAndarResponseBody;
import com.example.api.dto.ProductListAndarRequestBody;
import com.example.api.dto.ProductListAndarResponseBody;
import com.example.api.vo.ProductId;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class ProductRestAndarImpl implements ProductRest {

    private final RestTemplate restTemplate;

    @Value("${api.andar.product.list}")
    private String ANDAR_PRODUCT_LIST_API;

    @Value("${api.andar.product.detail}")
    private String ANDAR_PRODUCT_DETAIL_API;

    public ProductRestAndarImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ProductListAndarResponseBody getProductList() {
        return restTemplate.postForEntity(ANDAR_PRODUCT_LIST_API,
                ProductListAndarRequestBody.of(),
                ProductListAndarResponseBody.class).getBody();
    }

    @Override
    public ProductDetailAndarResponseBody getProductDetail(ProductId productId) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("productId", productId.value());
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(ANDAR_PRODUCT_DETAIL_API);
        String url = builder.buildAndExpand(urlParams).toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.add("x-cafe24-app-key", "pi6hNKzKLRGqH2oMrsKZ9A");

        return restTemplate.exchange(url,
            GET,
            new HttpEntity<>(headers),
            ProductDetailAndarResponseBody.class).getBody();
    }
}
