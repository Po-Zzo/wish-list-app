package com.example.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductListAndarResponseBody {

    @JsonProperty("pList")
    private List<Item> pList;


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Item {

        @JsonProperty("product_no")
        private int productNo;

        private boolean isGift;

    }

}
