package com.example.api.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.api.rest.ProductRestAndarImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class ProductServiceImplTest {

  @Autowired
  private ProductServiceImpl productService;

  @Test
  void updateProductListToRepository() {
    productService.updateProductListToRepository();
  }

}
