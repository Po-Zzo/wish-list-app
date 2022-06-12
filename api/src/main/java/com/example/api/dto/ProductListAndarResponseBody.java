package com.example.api.dto;

import com.example.api.vo.AndarProductId;
import com.example.api.vo.ProductId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
public class ProductListAndarResponseBody {

    @JsonProperty("pList")
    private List<Item> pList;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Builder
    public static class Item {

        @JsonProperty("product_no")
        private ProductId productId;

        private boolean isGift;

        public void setProductId(int productId) {
            this.productId = AndarProductId.of(productId);
        }
    }

}
