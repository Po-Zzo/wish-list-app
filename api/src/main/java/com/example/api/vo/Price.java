package com.example.api.vo;

import static java.util.Objects.isNull;

import java.util.Objects;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor(staticName = "of")
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Price price1 = (Price) o;
    return price == price1.price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(price);
  }
}
