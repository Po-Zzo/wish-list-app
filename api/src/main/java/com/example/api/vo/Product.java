package com.example.api.vo;

import com.example.api.dto.ProductDetailAndarResponseBody;
import com.example.api.dto.ProductDetailAndarResponseBody.ProductDetail;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Builder
public class Product {

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


  public static class ProductBuilder {

    public ProductBuilder urls(ProductId productId) {
      this.urls = Urls.of(productId.toUrl());
      return this;
    }
  }

  public static Product of(ProductDetailAndarResponseBody productDetailAndarResponseBody) {
    ProductDetail productDetail = productDetailAndarResponseBody.getProductDetail();
    return Product.builder()
        .productId(productDetail.getProductId())
        .urls(productDetail.getProductId())
        .mainImage()
        .price()
        .variablePrice()
        .salesPrice()
        .variableSalesPrice()
        .discountPrice()
        .relatedProducts()
        .build();
  }

}
