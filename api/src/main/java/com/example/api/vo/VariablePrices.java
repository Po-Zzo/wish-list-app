package com.example.api.vo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

/**
 * Price 가 변동한 과거 히스토리
 */
@RequiredArgsConstructor(staticName = "of")
public class VariablePrices {

  private final Set<RegisteredPrice> variablePrices;

  public static VariablePrices of() {
    return new VariablePrices(new HashSet<>());
  }

  public static VariablePrices of(RegisteredPrice registeredPrice) {
    VariablePrices of = VariablePrices.of();
    of.variablePrices.add(registeredPrice);
    return of;
  }

  public boolean add(RegisteredPrice registeredPrice) {
    return variablePrices.add(registeredPrice);
  }

  public VariablePrices orderByTime() {
    return variablePrices.stream()
        .sorted(RegisteredPrice::sortByRegisteredDate)
        .collect(Collectors.collectingAndThen(Collectors.toSet(),
            VariablePrices::of));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VariablePrices that = (VariablePrices) o;
    return Objects.equals(variablePrices, that.variablePrices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(variablePrices);
  }
}
