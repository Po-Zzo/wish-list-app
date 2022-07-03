package com.example.api.rest;

import static org.springframework.http.HttpMethod.GET;

import com.example.api.dto.ProductDetailAndarResponseBody;
import com.example.api.dto.ProductListAndarRequestBody;
import com.example.api.dto.ProductListAndarResponseBody;
import com.example.api.vo.DateVO;
import com.example.api.vo.Product;
import com.example.api.vo.ProductId;
import com.example.api.vo.ProductIdToProduct;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductRestAndarImpl implements ProductRest {

    @Value("${api.andar.product.list}")
    private String ANDAR_PRODUCT_LIST_API;

    @Value("${api.andar.product.detail}")
    private String ANDAR_PRODUCT_DETAIL_API;

    @Value("${api.andar.appkey}")
    private String ANDAR_API_APP_KEY;

    private static final String ANDAR_APP_KEY_HEADER_NAME = "x-cafe24-app-key";

    private final RestTemplate restTemplate;

    public ProductIdToProduct getProductIdToProduct() {
        return restTemplate.postForEntity(ANDAR_PRODUCT_LIST_API,
                ProductListAndarRequestBody.of(),
                ProductListAndarResponseBody.class).getBody()
            .toProductIdToItem();
    }

    @Override
    public Product getProductDetail(ProductId productId, DateVO dateVO) {
        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("productId", productId.value());
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(ANDAR_PRODUCT_DETAIL_API);
        String url = builder.buildAndExpand(urlParams).toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.add(ANDAR_APP_KEY_HEADER_NAME, ANDAR_API_APP_KEY);

        return restTemplate.exchange(url,
            GET,
            new HttpEntity<>(headers),
            ProductDetailAndarResponseBody.class).getBody()
            .toProduct(dateVO);
    }
}
