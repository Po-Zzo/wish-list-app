package com.example.api.vo;


import static java.util.Objects.isNull;

public class SalesPrice extends Price {

  private SalesPrice(String price) {
    super(price);
  }

  private SalesPrice(Integer price) {
    super(price);
  }

  public static SalesPrice of(String salesPrice) {
    return new SalesPrice(salesPrice);
  }

  public static SalesPrice of(Price price) {
    return new SalesPrice(price.price);
  }

  public boolean hasPrice() {
    return !(this.price == 0);
  }

}
