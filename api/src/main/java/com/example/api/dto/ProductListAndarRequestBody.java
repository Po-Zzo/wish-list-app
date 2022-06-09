package com.example.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductListAndarRequestBody {

    private final String mall_id = "andar01";

    public static ProductListAndarRequestBody of() {
        return new ProductListAndarRequestBody();
    }
}
