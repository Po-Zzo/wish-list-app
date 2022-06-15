package com.example.api.vo;

import static java.util.Objects.isNull;

import java.util.Map.Entry;
import java.util.TreeMap;
import lombok.RequiredArgsConstructor;

/**
 * Price 가 변동한 과거 히스토리
 * todo thread unsafe 하므로 write lock 을 걸 필요성이 있음
 */
@RequiredArgsConstructor(staticName = "of")
public class VariablePrices {

  private final TreeMap<DateVO, Price> variablePrices;

  public static VariablePrices of() {
    return new VariablePrices(new TreeMap<>());
  }

  public static VariablePrices of(RegisteredPrice registeredPrice) {
    VariablePrices of = VariablePrices.of();
    of.variablePrices.put(registeredPrice.getRegisteredDate(), registeredPrice.getPrice());
    return of;
  }

  /**
   *
   * @param registeredPrice
   */
  public void put(RegisteredPrice registeredPrice) {
    Price price = registeredPrice.getPrice();
    DateVO registeredDate = registeredPrice.getRegisteredDate();

    // 날짜가 일치하고 가격도 일치하면 갱신하지 않음
    if (hasSameKeyValue(registeredPrice)) {
      return;
    }

    Entry<DateVO, Price> higherEntry = variablePrices.higherEntry(registeredDate);
    Entry<DateVO, Price> lowerEntry = variablePrices.lowerEntry(registeredDate);

    if (!isNull(higherEntry) && price.equals(higherEntry.getValue())) {
      variablePrices.remove(higherEntry.getKey());
    } else if (!isNull(lowerEntry) && price.equals(lowerEntry.getValue())) {
      variablePrices.remove(lowerEntry.getKey());
    }

    variablePrices.put(registeredDate, price);

  }

  /**
   *
   * @param registeredPrice
   * @return
   */
  private boolean hasSameKeyValue(RegisteredPrice registeredPrice) {
    Price price = variablePrices.get(registeredPrice.getRegisteredDate());
    return !isNull(price)
        && price.equals(registeredPrice.getPrice());
  }

}
