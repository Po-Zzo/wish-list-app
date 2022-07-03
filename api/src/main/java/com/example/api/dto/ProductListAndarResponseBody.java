package com.example.api.dto;

import com.example.api.vo.AndarProductId;
import com.example.api.vo.Product;
import com.example.api.vo.ProductId;
import com.example.api.vo.ProductIdToProduct;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.*;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@NoArgsConstructor
public class ProductListAndarResponseBody {

    @JsonProperty("pList")
    private List<Item> pList;

    public static ProductListAndarResponseBody of() {
        return ProductListAndarResponseBody.of(new ArrayList<>());
    }

    public ProductIdToProduct toProductIdToItem() {
        Map<ProductId, Product> productIdItemMapNew = pList.stream()
            .collect(Collectors.toMap(Item::getId, Function.identity()));
        return ProductIdToProduct.of(productIdItemMapNew);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class Item implements Product {

        @JsonProperty("product_no")
        private ProductId id;

        private boolean isGift;

        public void setProductId(int productId) {
            this.id = AndarProductId.of(productId);
        }

    }

}
