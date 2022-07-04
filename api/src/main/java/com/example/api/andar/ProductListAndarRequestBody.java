package com.example.api.andar;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class ProductListAndarRequestBody {

    private final String mall_id = "andar01";

    static ProductListAndarRequestBody of() {
        return new ProductListAndarRequestBody();
    }
}
