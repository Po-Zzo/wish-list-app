package com.example.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
public class PromotionPeriod {

  @Nullable
  @JsonProperty("dc_price")
  private Price discountPrice;

  @JsonProperty("start_date")
  private DateVO startDate;

  @JsonProperty("end_date")
  private DateVO endDate;

  public void setDiscountPrice(String discountPrice) {
    this.discountPrice = Price.of(discountPrice);
  }

  public void setStartDate(String startDate) throws ParseException {
    this.startDate = DateVO.of(startDate);
  }

  public void setEndDate(String endDate) throws ParseException {
    this.endDate = DateVO.of(endDate);
  }

}
