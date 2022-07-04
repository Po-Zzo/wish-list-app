package com.example.api.rest;

import com.example.api.andar.ProductRestAndarImpl;
import com.example.api.vo.AndarProductId;
import com.example.api.vo.DateVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
@RestClientTest(value = ProductRestAndarImpl.class,
excludeAutoConfiguration = MockRestServiceServerAutoConfiguration.class)
class ProductRestAndarImplTest  {

    @Autowired
    private ProductRestAndarImpl productRestAndar;

    @Test
    @DisplayName("ProductList rest 요청 성공")
    void getProductList() {
        productRestAndar.getProductIdToProduct();
    }

    @Test
    @DisplayName("ProductDetail rest 요청 성공")
    void getProductDetail() {
        DateVO dateVO = DateVO.now();
        productRestAndar.getProductDetail(AndarProductId.of("6527"), dateVO);
        productRestAndar.getProductDetail(AndarProductId.of("5752"), dateVO);
    }
}
