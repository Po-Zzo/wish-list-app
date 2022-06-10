package com.example.api.vo;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AndarProductId implements ProductId {

  private final int productId;

  public static ProductId of(int productId) {
    return new AndarProductId(productId);
  }

  @Override
  public String value() {
    return String.valueOf(productId);
  }


}
