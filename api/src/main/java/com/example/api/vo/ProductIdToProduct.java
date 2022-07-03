package com.example.api.vo;

import java.util.Map;
import java.util.WeakHashMap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(staticName = "of")
public class ProductIdToProduct {

  private final Map<ProductId, Product> productIdToItem = new WeakHashMap<>();

  public static ProductIdToProduct of(Map<ProductId, Product> productIdToProduct) {
    ProductIdToProduct instance = ProductIdToProduct.of();
    instance.productIdToItem.putAll(productIdToProduct);
    return instance;
  }
}
