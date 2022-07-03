package com.example.api.repository;

import static java.util.Objects.isNull;

import com.example.api.vo.ProductImpl;
import com.example.api.vo.ProductId;
import com.example.api.vo.ProductIdToProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.WeakHashMap;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductDaoMemoryCacheImpl implements ProductDao {

    private final Map<Object, Object> MEMORY = new WeakHashMap<>();
    private final String productListKey = "productList";

    @Override
    public void saveProducts(ProductIdToProduct productIdToProduct) {
        MEMORY.put(productListKey, productIdToProduct);
    }

    @Override
    public ProductIdToProduct getProductList() {
        Object productIdToItem = MEMORY.get(productListKey);
        if (!isNull(productIdToItem)) {
            return (ProductIdToProduct) productIdToItem;
        }

        ProductIdToProduct result = ProductIdToProduct.of();
        MEMORY.put(productListKey, result);
        return result;
    }

    @Override
    public void updateProductDetail(ProductImpl product) {
        MEMORY.put(product.getId(), product);
    }

    @Override
    public ProductImpl getProduct(ProductId productId) {
        return (ProductImpl) MEMORY.get(productId);
    }


}
