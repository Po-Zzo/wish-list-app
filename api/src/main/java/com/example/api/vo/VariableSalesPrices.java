package com.example.api.vo;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class VariableSalesPrices {

  private final List<RegisteredPrice> variableSalesPrices = new ArrayList<>();

  public static VariableSalesPrices of(RegisteredPrice registeredPrice) {
    VariableSalesPrices of = VariableSalesPrices.of();
    of.variableSalesPrices.add(registeredPrice);
    return of;
  }
}
