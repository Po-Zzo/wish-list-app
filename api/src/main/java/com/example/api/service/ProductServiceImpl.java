package com.example.api.service;

import com.example.api.repository.ProductDao;
import com.example.api.rest.ProductRest;
import com.example.api.vo.ProductIdToProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

  private final ProductRest productRest;
  private final ProductDao productDao;

  @Override
  public void updateProductListToRepository() {
    productDao.saveProducts(productRest.getProductIdToProduct());
    ProductIdToProduct productList = productDao.getProductList();
    productRest.getProductIdToProduct();

  }
}
