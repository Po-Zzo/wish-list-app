package com.example.api.vo;

import java.util.Objects;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class RegisteredPrice {

  private final Price price;
  private final DateVO registeredDate;

  public static int sortByRegisteredDate(RegisteredPrice registeredPrice, RegisteredPrice anotherRegisteredPrice) {
    return registeredPrice.registeredDate.compareTo(anotherRegisteredPrice.registeredDate);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisteredPrice that = (RegisteredPrice) o;
    return Objects.equals(price, that.price) && Objects.equals(registeredDate,
        that.registeredDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, registeredDate);
  }
}
