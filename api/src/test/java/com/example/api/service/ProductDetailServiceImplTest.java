package com.example.api.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.api.dto.ProductDetailAndarResponseBody;
import com.example.api.dto.ProductListAndarResponseBody.Item;
import com.example.api.repository.ProductDao;
import com.example.api.rest.ProductRestAndarImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
    ProductDetailService.class,
    ProductDao.class
})
class ProductDetailServiceImplTest {

  @Autowired
  private ProductDetailService productDetailService;
  @Autowired
  private ProductDao productDao;

  @Autowired
  private ProductRestAndarImpl productRestAndar;

  @Test
  void updateProductDetailAll() {
    productDetailService.updateProductDetailAll();
  }

  @Test
  void updateProductDetail() {
    Item item = productRestAndar.getProductList().getPList().get(0);
    ProductDetailAndarResponseBody productDetail = productRestAndar.getProductDetail(
        item.getProductId());
    productDao.updateProductDetail();

    productDetailService.updateProductDetail();
  }
}
