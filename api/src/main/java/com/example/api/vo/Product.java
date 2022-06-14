package com.example.api.vo;

import com.example.api.dto.ProductDetailAndarResponseBody;
import com.example.api.dto.ProductDetailAndarResponseBody.ProductDetail;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Builder
public class Product {

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
      this.urls = Urls.of(productId.toUrl());
      return this;
    }
  }

  public static Product of(ProductDetailAndarResponseBody productDetailAndarResponseBody, DateVO dateVO) {
    ProductDetail productDetail = productDetailAndarResponseBody.getProductDetail();
    return Product.builder()
        .productId(productDetail.getProductId())
        .productName(productDetail.getProductName())
        .urls(productDetail.getProductId())
        .mainImage(productDetail.getMainImage())
        .price(productDetail.getPrice())
        .variablePrices(VariablePrices.of(RegisteredPrice.of(productDetail.getSalesPrice(), dateVO)))
        .salesPrice(productDetail.getSalesPrice())
        .variableSalesPrices(VariableSalesPrices.of(RegisteredPrice.of(productDetail.getSalesPrice(), dateVO)))
//        .discountPrice()
//        .relatedProducts()
        .promotionPeriod(productDetail.getPromotionPeriod())
        .build();
  }

}
