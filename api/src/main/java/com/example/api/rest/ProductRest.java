package com.example.api.rest;

import com.example.api.vo.DateVO;
import com.example.api.vo.Product;
import com.example.api.vo.ProductId;
import com.example.api.vo.ProductIdToProduct;

public interface ProductRest {

  ProductIdToProduct getProductIdToProduct();

  Product getProductDetail(ProductId productId, DateVO dateVO);


}
