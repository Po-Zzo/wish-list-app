package com.example.api.vo;

import static java.util.Objects.isNull;


public class Price {

  protected final int price;

  Price(Integer price) {
    if (isInValidPrice(price)) {
      price = 0;
    }

    this.price = price;
  }

  Price(String price) {
    if (isInValidPrice(price)) {
      price = "0";
    }

    this.price = (int) (Double.parseDouble(price));
  }

  public static Price of(String price) {
    if (isInValidPrice(price)) {
      price = "0";
    }

    return new Price(price);
  }

  public static boolean isInValidPrice(Object price) {
    return isNull(price);
  }


}
