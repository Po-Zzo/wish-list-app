package com.example.api.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class VariablePricesTest {

  @Test
  void of() {
  }

  @Test
  void add() {
    VariablePrices variablePrices = VariablePrices.of();
    DateVO DateVO1 = DateVO.of(LocalDate.of(2022, 1, 1));
    DateVO DateVO2 = DateVO.of(LocalDate.of(2022, 1, 2));
    DateVO DateVO3 = DateVO.of(LocalDate.of(2022, 1, 3));
    DateVO DateVO4 = DateVO.of(LocalDate.of(2022, 1, 4));

    variablePrices.add(RegisteredPrice.of(Price.of(1100), DateVO1));
    variablePrices.add(RegisteredPrice.of(Price.of(1200), DateVO3));
    variablePrices.add(RegisteredPrice.of(Price.of(1300), DateVO4));
    variablePrices.add(RegisteredPrice.of(Price.of(1400), DateVO2));
    variablePrices.add(RegisteredPrice.of(Price.of(1400), DateVO2));
    variablePrices.add(RegisteredPrice.of(Price.of(1400), DateVO1));

    System.out.printf(variablePrices.orderByTime().toString());
  }

  @Test
  void testOf() {
  }
}
