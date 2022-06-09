package com.example.api.vo;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Builder
public class ProductImpl {

  private final ProductId productId;
  private final Urls urls;
  private final Image representImage;
  private final Price price;
  private final VariablePrice variablePrice;
  private final SalesPrice salesPrice;
  private final VariableSalesPrice variableSalesPrice;
  private final DiscountRate discountRate;
  private final RelatedProducts relatedProducts;

}
