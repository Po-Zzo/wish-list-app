package com.example.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceImplTest {

  @Autowired
  private ProductServiceImpl productService;

  @Test
  void updateProductListToRepository() {
    productService.updateProductListToRepository();
  }

}
