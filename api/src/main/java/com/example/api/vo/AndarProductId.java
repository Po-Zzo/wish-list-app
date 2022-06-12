package com.example.api.vo;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AndarProductId implements ProductId {

  private final String productId;

  public static ProductId of(String productId) {
    return new AndarProductId(productId);
  }

  public static ProductId of(Integer productId) {
    return new AndarProductId(productId.toString());
  }

  @Override
  public String value() {
    return String.valueOf(productId);
  }


}
