package com.example.api.repository;

import com.example.api.dto.ProductListAndarResponseBody;
import com.example.api.vo.AndarProductId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = { ProductDaoMemoryCacheImpl.class })
class ProductDaoMemoryCacheImplTest {

    @Autowired
    private ProductDaoMemoryCacheImpl productDaoMemoryCache;

    @Test
    void saveProductList() {
        // given
        ProductListAndarResponseBody.Item item1 = ProductListAndarResponseBody.Item.builder().productId(
            AndarProductId.of("1")).isGift(false).build();
        ProductListAndarResponseBody.Item item2 = ProductListAndarResponseBody.Item.builder()
            .productId(AndarProductId.of("2")).isGift(false).build();

        // when
        productDaoMemoryCache.saveProductList(ProductListAndarResponseBody.of(Arrays.asList(
                item1, item2
        )));

        // then
        ProductListAndarResponseBody productList = productDaoMemoryCache.getProductList();

        assertThat(productList.getPList()).contains(item1, item2);
    }
}
