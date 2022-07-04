package com.example.api.vo;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Builder
public class ProductImpl implements Product {

  private final ProductId productId;
  private final ProductName productName;
  private final Urls urls;
  private final Image mainImage;
  private final Price price;
  private final VariablePrices variablePrices;
  private final SalesPrice salesPrice;
  private final VariableSalesPrices variableSalesPrices;
  private final DiscountRate discountRate;
  private final Price discountPrice;
  private final RelatedProducts relatedProducts;
  private final PromotionPeriod promotionPeriod;


  public ProductId getId() {
    return productId;
  }


  public static class ProductBuilder {

    public ProductBuilder urls(ProductId productId) {
//      this.urls = Urls.of(productId.toUrl());
      return this;
    }
  }



}
