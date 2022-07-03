package com.example.api.repository;

import com.example.api.vo.ProductImpl;
import com.example.api.vo.ProductId;
import com.example.api.vo.ProductIdToProduct;

public interface ProductDao {

    void saveProducts(ProductIdToProduct productIdToProduct);

    ProductIdToProduct getProductList();

    void updateProductDetail(ProductImpl product);

    ProductImpl getProduct(ProductId productId);
}
