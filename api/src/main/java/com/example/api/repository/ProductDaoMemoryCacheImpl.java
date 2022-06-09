package com.example.api.repository;

import com.example.api.dto.ProductListAndarResponseBody;
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
    public void saveProductList(ProductListAndarResponseBody productListAndarResponseBody) {
        MEMORY.put(productListKey, productListAndarResponseBody);
    }

    @Override
    public ProductListAndarResponseBody getProductList() {
        return (ProductListAndarResponseBody) MEMORY.get(productListKey);
    }
}
