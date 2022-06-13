package com.example.api.repository;

import com.example.api.dto.ProductListAndarResponseBody;
import com.example.api.vo.Product;
import com.example.api.vo.ProductId;

public interface ProductDao {

    void saveProductList(ProductListAndarResponseBody productListAndarResponseBody);

    ProductListAndarResponseBody getProductList();

    void updateProductDetail(Product product);

    Product getProduct(ProductId productId);
}
