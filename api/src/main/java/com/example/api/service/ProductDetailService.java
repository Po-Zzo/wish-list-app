package com.example.api.service;

import com.example.api.vo.DateVO;
import com.example.api.vo.ProductId;

public interface ProductDetailService {

  void updateProductDetailAll();

  void updateProductDetail(ProductId productId, DateVO dateVO);

}
