package com.example.api.vo;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AndarProductId implements ProductId {

  private final String productId;
  private final String ANDAR_PRODUCT_URL = "https://andar.co.kr/product/detail.html?product_no=";

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

  public Url toUrl() {
    return UrlImpl.of(ANDAR_PRODUCT_URL + productId);
  }

}
