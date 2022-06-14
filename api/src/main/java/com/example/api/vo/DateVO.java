package com.example.api.vo;

import static java.util.Objects.isNull;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Builder
@AllArgsConstructor(staticName = "of")
public class DateVO implements Comparable<DateVO> {

  private final LocalDateTime localDateTime;
  private LocalDate localDate;

  public static DateVO now() {
    return DateVO.of(LocalDateTime.now());
  }

  /**
   * @param offsetDateTimeFormat eg. 2012-10-01T09:45:00.000+02:00
   * @return
   */
  public static DateVO of(String offsetDateTimeFormat) throws ParseException {
    if (isNull(offsetDateTimeFormat)) {
      return null;
    }

    return DateVO.of(OffsetDateTime.parse(offsetDateTimeFormat)
        .truncatedTo(ChronoUnit.SECONDS).toLocalDateTime());
  }

  public static DateVO of(LocalDate localDate) {
    return DateVO.builder()
        .localDateTime(localDate.atStartOfDay())
        .localDate(localDate).build();
  }

  @Override
  public int compareTo(DateVO anotherDateVO) {
    return this.localDateTime.compareTo(anotherDateVO.localDateTime);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DateVO dateVO = (DateVO) o;
    return Objects.equals(localDateTime, dateVO.localDateTime) && Objects.equals(
        localDate, dateVO.localDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localDateTime, localDate);
  }
}
