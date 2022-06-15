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
    DateVO DateVO2 = DateVO.of(LocalDate.of(2022, 2, 2));
    DateVO DateVO3 = DateVO.of(LocalDate.of(2022, 3, 3));
    DateVO DateVO3_5 = DateVO.of(LocalDate.of(2022, 3, 5));
    DateVO DateVO4 = DateVO.of(LocalDate.of(2022, 4, 4));
    DateVO DateVO5 = DateVO.of(LocalDate.of(2022, 5, 5));
    DateVO DateVO6 = DateVO.of(LocalDate.of(2022, 6, 6));
    DateVO DateVO0 = DateVO.of(LocalDate.of(2021, 12, 31));
    DateVO DateV_1 = DateVO.of(LocalDate.of(2021, 12, 30));

    variablePrices.put(RegisteredPrice.of(Price.of(1100), DateVO1));
    // Price.of(1100), DateVO1 초기화 테스트
    variablePrices.put(RegisteredPrice.of(Price.of(1200), DateVO3));
    // Price.of(1100), DateVO1 정렬 테스트
    // Price.of(1200), DateVO3
    variablePrices.put(RegisteredPrice.of(Price.of(1300), DateVO4));
    // Price.of(1100), DateVO1 정렬 테스트
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4
    variablePrices.put(RegisteredPrice.of(Price.of(1400), DateVO2));
    // Price.of(1100), DateVO1  // 정렬테스트
    // Price.of(1400), DateVO2
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4
    variablePrices.put(RegisteredPrice.of(Price.of(1400), DateVO2));
    // Price.of(1100), DateVO1  // 중복값 저장 테스트
    // Price.of(1400), DateVO2
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4
    variablePrices.put(RegisteredPrice.of(Price.of(1400), DateVO1));
    // Price.of(1100), DateVO1
    // Price.of(1400), DateVO2  // higher 값과 price 가 같음
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4

    // Price.of(1400), DateVO1
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4

    // 중복없는 최신 값 추가
    variablePrices.put(RegisteredPrice.of(Price.of(1400), DateVO5));
    // Price.of(1400), DateVO1
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4
    // Price.of(1400), DateVO5

    // 중복있는 최신 값 추가
    variablePrices.put(RegisteredPrice.of(Price.of(1400), DateVO6));
    // Price.of(1400), DateVO1
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4
    // Price.of(1400), DateVO6

    // 중복없는 가장 오래된 값 추가
    variablePrices.put(RegisteredPrice.of(Price.of(1200), DateVO0));
    // Price.of(1200), DateVO0
    // Price.of(1400), DateVO1
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4
    // Price.of(1400), DateVO6

    // 중복있는 가장 오래된 값 추가
    variablePrices.put(RegisteredPrice.of(Price.of(1200), DateV_1));
    // Price.of(1200), DateV_1
    // Price.of(1400), DateVO1
    // Price.of(1200), DateVO3
    // Price.of(1300), DateVO4
    // Price.of(1400), DateVO6


    variablePrices.put(RegisteredPrice.of(Price.of(1200), DateVO3_5));
    // Price.of(1200), DateV_1
    // Price.of(1400), DateVO1
    // Price.of(1200), DateVO3  // Lower 값과 price 가 같음
    // Price.of(1300), DateVO4
    // Price.of(1400), DateVO6

    // Price.of(1200), DateV_1
    // Price.of(1400), DateVO1
    // Price.of(1200), DateVO3_5
    // Price.of(1300), DateVO4
    // Price.of(1400), DateVO6


    System.out.printf("성공.. 어썰트 귀찮당! ");
  }

  @Test
  void testOf() {
  }
}
