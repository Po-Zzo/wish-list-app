package com.example.api.rest;

import com.example.api.dto.ProductDetailAndarResponseBody;
import com.example.api.dto.ProductListAndarResponseBody;
import com.example.api.vo.ProductId;

public interface ProductRest {

  ProductListAndarResponseBody getProductList();

  ProductDetailAndarResponseBody getProductDetail(ProductId productId);


}
