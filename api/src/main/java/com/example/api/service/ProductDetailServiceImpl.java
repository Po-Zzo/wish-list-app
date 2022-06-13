package com.example.api.service;

import com.example.api.dto.ProductDetailAndarResponseBody;
import com.example.api.dto.ProductListAndarResponseBody.Item;
import com.example.api.repository.ProductDao;
import com.example.api.rest.ProductRest;
import com.example.api.vo.Product;
import com.example.api.vo.ProductId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductDetailServiceImpl implements ProductDetailService {

  private final ProductDao productDao;
  private final ProductRest productRest;

  @Override
  public void updateProductDetailAll() {

    for (Item item : productDao.getProductList().getPList()) {
      updateProductDetail(item.getProductId());
    }

  }

  @Override
  public void updateProductDetail(ProductId productId) {
    ProductDetailAndarResponseBody productDetail = productRest.getProductDetail(productId);
    Product product = productDao.getProduct(productId);

    productDao.updateProductDetail(product);
  }
}
