package com.example.api.vo;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Builder
public class ProductImpl implements Product {

  private final ProductId productId;
  private final Urls urls;
  private final Image mainImage;
  private final Price price;
  private final VariablePrice variablePrice;
  private final SalesPrice salesPrice;
  private final VariableSalesPrice variableSalesPrice;
  private final DiscountRate discountRate;
  private final Price discountPrice;
  private final RelatedProducts relatedProducts;

  public ProductId getId() {
    return productId;
  }

}
