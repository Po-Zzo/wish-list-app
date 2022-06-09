package com.example.api.repository;

import com.example.api.dto.ProductListAndarResponseBody;

public interface ProductDao {

    void saveProductList(ProductListAndarResponseBody productListAndarResponseBody);

    ProductListAndarResponseBody getProductList();
}
