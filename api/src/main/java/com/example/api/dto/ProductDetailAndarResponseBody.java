package com.example.api.dto;

import static java.util.Objects.isNull;

import com.example.api.vo.AndarProductId;
import com.example.api.vo.DateVO;
import com.example.api.vo.Price;
import com.example.api.vo.ProductId;
import com.example.api.vo.SalesPrice;
import com.example.api.vo.Url;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
public class ProductDetailAndarResponseBody {

  @JsonProperty("productsdetail")
  private ProductDetail productDetail;

  @Getter
  @NoArgsConstructor
  public static class ProductDetail {

    @JsonProperty("product_no")
    private ProductId productId;

    @JsonProperty("discount_price")
    private SalesPrice salesPrice;

    private Price price;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("promotion_period")
    private PromotionPeriod promotionPeriod;

    @JsonProperty("small_image")
    private String mainImage;

    public void setProductId(int productId) {
      this.productId = AndarProductId.of(productId);
    }

    public void setSalesPrice(String salesPrice) {
      this.salesPrice = SalesPrice.of(salesPrice);

      if (!this.salesPrice.hasPrice()) {
        this.salesPrice = SalesPrice.of(this.price);
      }

    }

    public void setPrice(String price) {
      this.price = Price.of(price);

      if (isNull(this.salesPrice) || !this.salesPrice.hasPrice()) {
        this.salesPrice = SalesPrice.of(this.price);
      }
    }

    public Url getUrl() {
      return productId.toUrl();
    }

  }

  @Getter
  @NoArgsConstructor
  public static class PromotionPeriod {

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
}
