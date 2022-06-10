package com.example.api.vo;

import static java.util.Objects.isNull;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class DateVO {

  private final LocalDateTime localDateTime;

  /**
   *
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

}
