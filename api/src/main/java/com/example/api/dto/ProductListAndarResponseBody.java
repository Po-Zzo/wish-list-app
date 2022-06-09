package com.example.api.dto;

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
        private int productNo;

        private boolean isGift;

    }

}
