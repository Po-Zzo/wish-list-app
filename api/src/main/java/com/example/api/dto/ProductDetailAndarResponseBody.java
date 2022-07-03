package com.example.api.dto;

import static java.util.Objects.isNull;

import com.example.api.vo.AndarProductId;
import com.example.api.vo.DateVO;
import com.example.api.vo.Image;
import com.example.api.vo.ImageImpl;
import com.example.api.vo.Price;
import com.example.api.vo.Product;
import com.example.api.vo.ProductId;
import com.example.api.vo.ProductImpl;
import com.example.api.vo.ProductName;
import com.example.api.vo.ProductNameImpl;
import com.example.api.vo.PromotionPeriod;
import com.example.api.vo.RegisteredPrice;
import com.example.api.vo.SalesPrice;
import com.example.api.vo.Url;
import com.example.api.vo.VariablePrices;
import com.example.api.vo.VariableSalesPrices;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDetailAndarResponseBody {

  @JsonProperty("productsdetail")
  private ProductDetail productDetail;

  /**
   * 사이트 내에서 삭제되어 더이상 정보를 알 수 없는 제품인지 확인
   * @return
   */
  public boolean isDeleted() {
    return isNull(productDetail);
  }

  @Getter
  @NoArgsConstructor
  public static class ProductDetail {

    @JsonProperty("product_no")
    private ProductId productId;

    @JsonProperty("discount_price")
    private SalesPrice salesPrice;

    private Price price;

    @JsonProperty("product_name")
    private ProductName productName;

    @JsonProperty("promotion_period")
    private PromotionPeriod promotionPeriod;

    @JsonProperty("small_image")
    private Image mainImage;

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

    public void setMainImage(String imageUrl) {
      this.mainImage = ImageImpl.of(imageUrl);
    }

    public void setProductName(String productName) {
      this.productName = ProductNameImpl.of(productName);
    }

    public Url getUrl() {
      return productId.toUrl();
    }

  }

  public Product toProduct(DateVO dateVO) {

    return ProductImpl.builder()
        .productId(productDetail.getProductId())
        .productName(productDetail.getProductName())
//        .urls(productDetail.getProductId())
        .mainImage(productDetail.getMainImage())
        .price(productDetail.getPrice())
        .variablePrices(VariablePrices.of(RegisteredPrice.of(productDetail.getSalesPrice(), dateVO)))
        .salesPrice(productDetail.getSalesPrice())
        .variableSalesPrices(
            VariableSalesPrices.of(RegisteredPrice.of(productDetail.getSalesPrice(), dateVO)))
//        .discountPrice()
//        .relatedProducts()
        .promotionPeriod(productDetail.getPromotionPeriod())
        .build();

  }

}
